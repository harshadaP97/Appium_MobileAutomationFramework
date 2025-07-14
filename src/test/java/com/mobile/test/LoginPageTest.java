package com.mobile.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;

import com.mobile.base.TestBase;
import com.mobile.pages.HomePage;
import com.mobile.pages.LoginPage;
import com.mobile.util.TestDataUtil;

public class LoginPageTest extends TestBase {

    public LoginPage loginPage;
    public HomePage homePage;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        loginPage = new LoginPage();
    }

    @DataProvider
    public Object[][] getUserData() {
        return TestDataUtil.getUserDataFromExcel("Sheet1");
    }

    @Test(dataProvider = "getUserData", enabled = true)
    public void validateLogin(String username, String password) {
        logger.info("Starting login test for user: " + username);

        homePage = loginPage.login(username, password);
        Assert.assertEquals(homePage.validateHomePage(), "PRODUCTS");

        logger.pass("Login successful for user: " + username);
    }
}
