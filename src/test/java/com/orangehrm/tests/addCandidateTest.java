package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentCanPage;
import com.orangehrm.utils.Log;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addCandidateTest extends BaseTest {

    @Test
    @Description("")
    public void addCandidateTest() throws Exception {
        Log.startTestCase("addCandidateTest");
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        RecruitmentCanPage recruitmentCanPage = loginPage.loginToOrangeHRM().afterSuccessfulLogin().openRecruitmentCanPage();
        recruitmentCanPage.addCandidate("Ganesh", "D", "Bhosale","Senior QA Lead", "ganesh0990@gmail.com", "9849294509", "Automation, Selenium, Java, SQL","2023-11-25");
        Log.info("Candidate Creation Completed - Validating Status");
        Log.info(recruitmentCanPage.getApplicationFormCanName());
        String applicationStatus = recruitmentCanPage.getApplicationFormStatus();
        Assert.assertEquals(applicationStatus, "Status: Application Initiated");

        if(applicationStatus.equals("Status: Application Initiated")){
            Assert.assertEquals(applicationStatus, "Status: Application Initiated");
            Log.info(applicationStatus);
            Log.info("TC Passed : Candidate Application created!");
        }
        else{
            Assert.fail("TC Failed - Candidate application not Created");
        }
        Log.endTestCase("addCandidateTest");
    }
}
