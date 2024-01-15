package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentCanPage;
import com.orangehrm.utils.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class searchCandidateTest extends BaseTest {

    public searchCandidateTest(){
        super();
    }

    @Test
    public void searchCandidateByName() throws Exception {
        Log.startTestCase("searchCandidateByName");
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        RecruitmentCanPage recruitmentCanPage = loginPage.loginToOrangeHRM().afterSuccessfulLogin().openRecruitmentCanPage();
        recruitmentCanPage.clickCandidateButton();
        Log.info("Getting Candidate Details: ");
        List<String> candidateNames = recruitmentCanPage.getCandidateNames();

        for(String name: candidateNames){
            if(name.contains("Ganesh")){
                Assert.assertEquals(name, "Ganesh D Bhosale");
                Log.info("Name : "+name);
                break;
            }
        }

        String canStatus = recruitmentCanPage.getCandidateStatus("Ganesh D Bhosale");
        Log.info("Candidate Status: "+canStatus);

    }
}
