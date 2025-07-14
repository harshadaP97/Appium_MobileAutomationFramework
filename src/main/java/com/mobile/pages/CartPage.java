package com.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobile.base.TestBase;
import com.mobile.util.WaitUtil;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends TestBase{

	@FindBy(xpath="//android.widget.TextView[@text='YOUR CART']")
	WebElement cartPageTitle;
	
	@FindBy(xpath="//android.widget.TextView[@text='CHECKOUT']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='test-First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='test-Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
	WebElement zipCode;
	
	@FindBy(xpath="//android.widget.TextView[@text='CONTINUE']")
	WebElement continueButton;
	
	public CartPage()
	{
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public String validateCartPage()
	{
		return cartPageTitle.getText();
	}
	
	public CheckoutPage checkoutProduct(String fName, String lName, String zip)
	{
        logger.info("Click on checkout button");
		checkoutButton.click();
		WaitUtil.waitForVisible(firstName, 2);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		zipCode.sendKeys(zip);
		logger.info("Filled User info and click on continue button");
		continueButton.click();
		return new CheckoutPage();
	}
	
}
