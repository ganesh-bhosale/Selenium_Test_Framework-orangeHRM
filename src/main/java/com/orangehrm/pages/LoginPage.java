package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import com.orangehrm.utils.Log;
import com.orangehrm.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public LoginPage(){
        super();
    }

    // Page Locators
    By loginPageTitle = By.className("orangehrm-login-title");
    By userName = By.cssSelector("input[name='username']");
    By passWord = By.name("password");
    By loginButton = By.className("orangehrm-login-button");

    By errorMsg = By.className("oxd-alert-content-text");

    By getLoginPageTitle = By.className("orangehrm-login-title");
    By DashboardTitle = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6");


    // Page Actions
    public void inputUsername(String username){
        inputText(userName, username);
    }

    public void inputPassword(String password){
        inputText(passWord, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    // Successful Login - Valid Username & Password
    public LoginPage loginToOrangeHRM() throws Exception {
        waitForVisibilityOfElement(loginPageTitle);
        inputUsername(PropertyReader.readKey("username"));
        inputPassword(PropertyReader.readKey("password"));
        clickLoginButton();
        waitForVisibilityOfElement(DashboardTitle);
        return this;
    }

    // Unsuccessful Login - Invalid Username/Password
    public String failLoginToOrangeHRM(String username, String password) throws InterruptedException {
        waitForVisibilityOfElement(loginPageTitle);
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
        waitForVisibilityOfElement(errorMsg);
        return getText(errorMsg);
    }

    public String getLoginPageTitleMsg(){
        waitForVisibilityOfElement(loginPageTitle);
        return getText(loginPageTitle);
    }
    public DashboardPage afterSuccessfulLogin(){
        return new DashboardPage();
    }
}
