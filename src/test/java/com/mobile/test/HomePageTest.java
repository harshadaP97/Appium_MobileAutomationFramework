package com.mobile.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobile.base.TestBase;
import com.mobile.pages.HomePage;
import com.mobile.pages.LoginPage;

public class HomePageTest extends TestBase {

	public LoginPage loginPage;
	public HomePage homePage;

	public HomePageTest() throws IOException {
		super();

	}
	 @BeforeMethod(alwaysRun = true)
	    public void loginBeforeTest() {
	        loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	    }
	/*@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		launchMobileApp();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}*/

	@Test(enabled=true)
	public void varifyAddandRemoveFromCart() throws IOException {
        logger.info("Click on add to cart button");

		// Check after adding to card count is getting display
		Assert.assertTrue(homePage.validateAddToCart(), "Cart count should be visible after adding item");
        logger.pass("Cart count increase");

        logger.info("Click on remove from cart button");

		// Check when cart is empty count should not be display
		Assert.assertFalse(homePage.validateRemove(), "Cart count should not be visible after removing item");
        logger.pass("Cart count is zero");

	}
	
	@Test
	public void validateLogout()
	{
		loginPage=homePage.validateLogout();
		Assert.assertEquals(loginPage.validateLoginPage(),"LOGIn","User logout successfully");
        logger.pass("User logout successfully");

		
	}
	
}
