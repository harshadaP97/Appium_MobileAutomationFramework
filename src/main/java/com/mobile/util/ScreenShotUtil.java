package com.mobile.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mobile.base.TestBase;

public class ScreenShotUtil extends TestBase {

	public static String takeScreenshotAtEndOfTest() {
	    try {
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
	        FileUtils.copyFile(scrFile, new File(path));
	        return path;
	    } catch (Exception e) {
	        System.out.println("⚠️ Screenshot capture failed: " + e.getMessage());
	        return null;
	    }
	}

}
