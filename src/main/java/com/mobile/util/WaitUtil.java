package com.mobile.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mobile.base.TestBase;

public class WaitUtil extends TestBase {

    public static void waitForInvisibility(By locator, int timeoutInSeconds) {
        new WebDriverWait(TestBase.driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForVisible(WebElement element, int timeoutInSeconds) {
        new WebDriverWait(TestBase.driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }
}