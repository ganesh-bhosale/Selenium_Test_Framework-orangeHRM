package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.Log;
import com.orangehrm.utils.PropertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    public loginTest(){
        super();
    }

    @Test
    @Description("Login with Invalid Credentials, Verify if Error Message is displayed")
    public void testLoginWithInvalidCredentials() throws Exception {
        Log.startTestCase("testLoginWithInvalidCredentials");
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        String errorMsg = loginPage.failLoginToOrangeHRM(PropertyReader.readKey("username"), PropertyReader.readKey("incorrectPassword"));
        Log.info("Error Message - "+errorMsg);
        Assert.assertEquals(errorMsg, PropertyReader.readKey("errorMsg"));
        Log.info("Failed to login");
        Log.endTestCase("testLoginWithInvalidCredentials");
    }

    @Test
    @Description("Login with Valid Credentials, Verify if DashBoard Title is displayed")
    public void testLoginwithValidCredentails() throws Exception {
        Log.startTestCase("testLoginwithValidCredentails");
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.loginToOrangeHRM().afterSuccessfulLogin();
        String dashboardTitleName = dashboardPage.getDashboardPageTitle();
        Assert.assertEquals(dashboardTitleName, PropertyReader.readKey("dashboardTitle"));
        Log.info("Title - "+dashboardTitleName);
        Log.info("Logged into application Successfully");
        Log.endTestCase("testLoginwithValidCredentails");
    }
}
