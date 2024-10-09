package org.screens;

import org.base.Base;
import org.openqa.selenium.By;

public class Home extends Base {

    SideMenu sideMenu;
    AlertPopup alertPopup;

    private final By menuIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");

    public Home (){
        sideMenu = new SideMenu();
        alertPopup = new AlertPopup();
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }
    public AlertPopup getAlertPopup(){
        return alertPopup;
    }

    public By getMenuIcon() {
        return menuIcon;
    }

    public void clickOnMenuIcon(){
        waits.waitUntilElementIsClickable(menuIcon).click();
    }

}
