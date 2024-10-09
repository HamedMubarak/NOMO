package org.screens;

import org.base.Base;
import org.openqa.selenium.By;

public class SideMenu extends Base {

    private final By loginButton = By.xpath("//android.widget.TextView[@text=\"Log In\"]");
    private final By logoutButton = By.xpath("//android.widget.TextView[@text=\"Log Out\"]");

    public By getLoginButton(){
        return loginButton;
    }

    public void clickOnLoginButton(){
        waits.waitUntilElementIsClickable(loginButton).click();
    }
    public void clickOnLogoutButton(){waits.waitUntilElementIsClickable(logoutButton).click();}
}
