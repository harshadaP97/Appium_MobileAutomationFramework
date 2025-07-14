package com.mobile.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobile.base.TestBase;
import com.mobile.pages.CartPage;
import com.mobile.pages.CheckoutPage;
import com.mobile.pages.HomePage;
import com.mobile.pages.LoginPage;

public class CartPageTest extends TestBase {

	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;


	public CartPageTest() throws IOException {
		super();

	}

	 @BeforeMethod(alwaysRun = true)
	    public void loginBeforeTest() {
	        loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	    }
/*	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		launchMobileApp();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}*/
	
	@Test
	public void validateSuccessfulOrder()
	{
		homePage.validateAddToCart();
		cartPage=homePage.gotoCartPage();
		Assert.assertEquals(cartPage.validateCartPage(),"YOUR CART","Cart Page is not validated");
		logger.info("Landed on cart page");
		checkoutPage=cartPage.checkoutProduct(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));
		logger.info("Landed on Payment page");
		Assert.assertEquals(checkoutPage.successfulOrder(),"THANK YOU FOR YOU ORDER","Order is not successful");
        logger.pass("Order placed successfully");

		
	}
}
