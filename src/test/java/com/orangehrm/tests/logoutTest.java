package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.Log;
import com.orangehrm.utils.PropertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class logoutTest extends BaseTest {
    public logoutTest(){
        super();
    }

    @Test
    @Description("Verify Logout functionality")
    public void testLogoutFunctionality() throws Exception {
        Log.startTestCase("testLogoutFunctionality");
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.loginToOrangeHRM().afterSuccessfulLogin();
        Log.info("Logged into Application");
        try{
            dashboardPage.doLogout();
            String loginPageTitle = loginPage.getLoginPageTitleMsg();
            Assert.assertEquals(loginPageTitle, PropertyReader.readKey("loginPageTitle"));
            Log.info("Logged Out Successfully");
            Log.endTestCase("testLogoutFunctionality");
        }
        catch (Exception e){
            Assert.fail("Log out failed !");
            Log.endTestCase("testLogoutFunctionality");
        }
    }
}
