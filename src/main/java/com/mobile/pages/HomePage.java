package com.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;


import com.mobile.base.TestBase;
import com.mobile.util.WaitUtil;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase{

	@FindBy(xpath="//android.widget.TextView[@text='PRODUCTS']")
	WebElement productsText;
	
	@FindBy(xpath="(//android.widget.TextView[@text='ADD TO CART'])[1]")
	WebElement addToCartButton;

	@FindBy(xpath="//android.widget.TextView[@text='REMOVE']")
	WebElement removeButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='LOGOUT']")
	WebElement logoutButton;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
	WebElement menuButton;
		
	private By cartBadgeWithCount = By.xpath("//android.widget.TextView[@text='1']");

	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
	WebElement cartLogo;



	public HomePage()
	{
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public String validateHomePage() 
	{
		return productsText.getText();
	}
	
	public boolean validateAddToCart()
	{
		addToCartButton.click();
		return driver.findElements(cartBadgeWithCount).size() > 0;
	}
	
	public boolean validateRemove()
	{
		removeButton.click();
		WaitUtil.waitForInvisibility(cartBadgeWithCount, 5);
		return driver.findElements(cartBadgeWithCount).size() > 0;

		}
	
	public LoginPage validateLogout()
	{
        logger.info("Click on Menu button");
		menuButton.click();
        logger.info("Click on logout button");
		logoutButton.click();
		return new LoginPage();
	}
	
	public CartPage gotoCartPage()
	{
		cartLogo.click();
		return new CartPage();
	}
}
