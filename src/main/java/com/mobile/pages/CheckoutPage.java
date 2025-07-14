package com.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobile.base.TestBase;
import com.mobile.util.ScrollUtil;
import com.mobile.util.WaitUtil;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage extends TestBase {

	@FindBy(xpath="//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
	WebElement checkoutPageTitle;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='test-FINISH']")
	WebElement finishButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
	WebElement confirmationMessage;
	
	public CheckoutPage()
	{
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	
	public String successfulOrder()
	{
		ScrollUtil.scrollToElementByDescription("test-FINISH", driver);
		finishButton.click();
		WaitUtil.waitForVisible(confirmationMessage,5);
		return confirmationMessage.getText();
	}
}
