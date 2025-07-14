package com.mobile.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobile.base.TestBase;
import com.mobile.pages.HomePage;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='test-Username']")
	WebElement userName;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='test-Password']")
	WebElement password;
	
	@FindBy(xpath="//android.widget.TextView[@text='LOGIN']")
	WebElement loginButton;

	public LoginPage()
	{
		//PageFactory.initElements(driver, this);
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public HomePage login(String name,String pwd) 
	{
		userName.sendKeys(name);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	
	public String validateLoginPage()
	{
		return loginButton.getText();
	}
}
