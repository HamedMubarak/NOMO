package org.screens;

import io.appium.java_client.AppiumBy;
import org.base.Base;
import org.openqa.selenium.By;

public class Checkout extends Base {

    private final By toPaymentButton = AppiumBy.accessibilityId("To Payment button");

    public By getToPaymentButton(){return toPaymentButton;}

}
