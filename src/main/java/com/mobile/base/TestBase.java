package com.mobile.base;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static Properties prop;
	public static AndroidDriver driver;
	public static WebDriverWait wait;

	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeSuite
	public void setUpExtentReport() throws IOException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Reports/Mobile_" + System.currentTimeMillis() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Load config
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/mobile/config/config.properties");
		prop.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	public void launchMobileApp(Method method) {
		logger = extent.createTest(method.getName());

		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", prop.getProperty("platformName"));
			cap.setCapability("appium:automationName", prop.getProperty("automationName"));
			cap.setCapability("appium:deviceName", prop.getProperty("deviceName"));
			cap.setCapability("appium:udid", prop.getProperty("udid"));
			cap.setCapability("appium:platformVersion", prop.getProperty("platformVersion"));
			cap.setCapability("appium:appPackage", prop.getProperty("appPackage"));
			cap.setCapability("appium:appActivity", prop.getProperty("appActivity"));
			cap.setCapability("appium:noReset", Boolean.parseBoolean(prop.getProperty("noReset")));

			driver = new AndroidDriver(new URL(prop.getProperty("url")), cap);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(7));

			logger.log(Status.INFO, "App launched successfully");

		} catch (Exception e) {
			logger.log(Status.FAIL, "App launch failed: " + e.getMessage());
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = takeScreenshot(result.getName());
			logger.fail("Test Failed: " + result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped: " + result.getThrowable());
		} else {
			logger.pass("Test Passed");
		}

		if (driver != null) {
			try {
				driver.terminateApp(prop.getProperty("appPackage"));
				logger.info("App terminated");
			} catch (Exception e) {
				logger.warning("Could not terminate app: " + e.getMessage());
			}

			driver.quit();
			logger.info("Driver quit");
		}

		extent.flush();
	}

	public String takeScreenshot(String name) {
		try {
			String path = System.getProperty("user.dir") + "/screenshots/" + name + "_" + System.currentTimeMillis()
					+ ".png";
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			java.nio.file.Files.copy(src.toPath(), new File(path).toPath());
			return path;
		} catch (Exception e) {
			logger.warning("Screenshot failed: " + e.getMessage());
			return null;
		}
	}
}
