package org.screens;

import org.base.Base;
import org.openqa.selenium.By;

public class AlertPopup extends Base {

    private final By alertTitle = By.id("android:id/alertTitle");
    private final By alertConfirmButton = By.id("android:id/button1");
    private final By alertCancelButton = By.id("android:id/button2");

    public By getAlertTitle(){return alertTitle;}

    public void clickOnAlertConfirmButton(){waits.waitUntilElementIsClickable(alertConfirmButton).click();}

}
