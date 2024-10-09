package org.tests;

import io.cucumber.java.en.*;
import org.base.Base;
import org.testng.Assert;

public class CommonStepDefs extends Base {

    @Given("myDemo app is opened")
    public void myDemoAppIsOpened(){
        Assert.assertTrue(waits.findElementWithVisibilityWait(device.home.getMenuIcon()).isDisplayed());
    }

    @When("click on menu icon")
    public void clickOnMenuIcon(){
        device.home.clickOnMenuIcon();
    }

    @Then("side menu should be displayed")
    public void sideMenuShouldBeDisplayed(){
        Assert.assertTrue(waits.findElementWithVisibilityWait(device.home.getSideMenu().getLoginButton()).isDisplayed());
    }

    @When("click on login button in side menu")
    public void clickOnLoginButtonInSideMenu(){
        device.home.getSideMenu().clickOnLoginButton();
    }

    @Then("login form should be displayed")
    public void loginFormShouldBeDisplayed() {
        Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getLoginButton()).isDisplayed());
    }

    @When("login with {string}{string}")
    public void loginWithUsernameAndPassword(String username, String password) {
        waits.findElementWithVisibilityWait(device.loginForm.getUsername()).clear();
        waits.findElementWithVisibilityWait(device.loginForm.getUsername()).sendKeys(configTestData.getProperty(username));
        waits.findElementWithVisibilityWait(device.loginForm.getPassword()).clear();
        waits.findElementWithVisibilityWait(device.loginForm.getPassword()).sendKeys(configTestData.getProperty(password));
        device.loginForm.clickOnLoginButton();
    }

    @Then("checkout screen should be displayed")
    public void checkoutScreenShouldBeDisplayed() {
        Assert.assertTrue(waits.findElementWithVisibilityWait(device.checkout.getToPaymentButton()).isDisplayed());
    }

    @When("logout from myDemo app")
    public void logoutFromMyDemoApp() {
        device.home.getSideMenu().clickOnLogoutButton();
        Assert.assertEquals(waits.findElementWithVisibilityWait(device.home.getAlertPopup().getAlertTitle()).getText(),"Log Out");
        device.home.getAlertPopup().clickOnAlertConfirmButton();
        Assert.assertEquals(waits.findElementWithVisibilityWait(device.home.getAlertPopup().getAlertTitle()).getText(),"You are successfully logged out.");
        device.home.getAlertPopup().clickOnAlertConfirmButton();
        Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getLoginButton()).isDisplayed());
    }

    @Then("error message {string} should be displayed when login with {string}{string}")
    public void errorMessageShouldBeDisplayed(String errorMessage,String username, String password) {
        if(waits.findElementWithVisibilityWait(device.loginForm.getUsername()).getText().equals(configTestData.getProperty("noMatchUsername"))
            && configTestData.getProperty(password).equals(configTestData.getProperty("noMatchPass"))){
            Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getNoMatchCredentialsValidation()).isDisplayed());
            Assert.assertEquals(waits.findElementWithVisibilityWait(device.loginForm.getNoMatchCredentialsValidation()).getText()
                    , configTestData.getProperty(errorMessage));
        }
        if(waits.findElementWithVisibilityWait(device.loginForm.getUsername()).getText().equals(configTestData.getProperty("emptyUsername"))
                && configTestData.getProperty(password).equals(configTestData.getProperty("emptyPass"))){
            Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getRequiredUsernameValidation()).isDisplayed());
            Assert.assertEquals(waits.findElementWithVisibilityWait(device.loginForm.getRequiredUsernameValidation()).getText()
                    , configTestData.getProperty(errorMessage));
        }
        if(waits.findElementWithVisibilityWait(device.loginForm.getUsername()).getText().equals(configTestData.getProperty("emptyUsername"))
                && configTestData.getProperty(password).equals(configTestData.getProperty("standardPass"))){
            Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getRequiredUsernameValidation()).isDisplayed());
            Assert.assertEquals(waits.findElementWithVisibilityWait(device.loginForm.getRequiredUsernameValidation()).getText()
                    , configTestData.getProperty(errorMessage));
        }
        if(waits.findElementWithVisibilityWait(device.loginForm.getUsername()).getText().equals(configTestData.getProperty("standardUsername"))
                && configTestData.getProperty(password).equals(configTestData.getProperty("emptyPass"))){
            Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getRequiredPasswordEValidation()).isDisplayed());
            Assert.assertEquals(waits.findElementWithVisibilityWait(device.loginForm.getRequiredPasswordEValidation()).getText()
                    , configTestData.getProperty(errorMessage));
        }
        if(waits.findElementWithVisibilityWait(device.loginForm.getUsername()).getText().equals(configTestData.getProperty("lockedUsername"))
                && configTestData.getProperty(password).equals(configTestData.getProperty("standardPass"))){
            Assert.assertTrue(waits.findElementWithVisibilityWait(device.loginForm.getLockedCredentialsValidation()).isDisplayed());
            Assert.assertEquals(waits.findElementWithVisibilityWait(device.loginForm.getLockedCredentialsValidation()).getText()
                    , configTestData.getProperty(errorMessage));
        }
    }

}
