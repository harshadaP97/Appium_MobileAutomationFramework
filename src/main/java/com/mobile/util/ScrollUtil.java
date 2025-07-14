package com.mobile.util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ScrollUtil {

	// In WaitUtil or ScrollUtil class
	public static void scrollToElementByDescription(String contentDesc, AppiumDriver driver) {
	    driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"" + contentDesc + "\"))"
	    ));
	}

}
