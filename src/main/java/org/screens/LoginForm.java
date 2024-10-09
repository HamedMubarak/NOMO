package org.screens;

import io.appium.java_client.AppiumBy;
import org.base.Base;
import org.openqa.selenium.By;

public class LoginForm extends Base {

    private final By loginButton = AppiumBy.accessibilityId("Login button");
    private final By username = AppiumBy.accessibilityId("Username input field");
    private final By password = AppiumBy.accessibilityId("Password input field");
    private final By requiredUsernameValidation = By.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private final By requiredPasswordEValidation = By.xpath("//android.widget.TextView[@text=\"Password is required\"]");
    private final By noMatchCredentialsValidation = By.xpath("//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]");
    private final By lockedCredentialsValidation = By.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]");

    public By getLoginButton(){return loginButton;}
    public By getUsername(){return username;}
    public By getPassword(){return password;}
    public By getRequiredUsernameValidation(){return requiredUsernameValidation;}
    public By getRequiredPasswordEValidation(){return requiredPasswordEValidation;}
    public By getNoMatchCredentialsValidation(){return noMatchCredentialsValidation;}
    public By getLockedCredentialsValidation(){return lockedCredentialsValidation;}

    public void clickOnLoginButton() {waits.waitUntilElementIsClickable(loginButton).click();}

}
