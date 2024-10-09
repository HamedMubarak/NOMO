package org.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.base.Base.driverHandler;

public class Waits {

    public WebElement findElementWithVisibilityWait(By locator) {
        Wait<AndroidDriver> wait = new FluentWait<>(driverHandler.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driverHandler.getDriver().findElement(locator);
        } catch (TimeoutException e) {
            return null;
        }
    }

    public WebElement waitUntilElementIsClickable(By locator) {
        Wait<AndroidDriver> wait = new FluentWait<>(driverHandler.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementClickInterceptedException.class);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return driverHandler.getDriver().findElement(locator);
        } catch (ElementClickInterceptedException e) {
            return null;
        }
    }


}
