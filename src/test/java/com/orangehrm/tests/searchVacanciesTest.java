package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentVacPage;
import com.orangehrm.utils.Log;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class searchVacanciesTest extends BaseTest {

    public searchVacanciesTest(){
        super();
    }

    @Test
    @Description("Search Vacancy from Vacancies using dropdown filters")
    public void searchVacancyTest() throws Exception {
        Log.startTestCase("searchVacancyTest");
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        RecruitmentVacPage recruitmentVacPage = loginPage.loginToOrangeHRM().afterSuccessfulLogin().openRecruitmentPage();
        Log.info("Recruitment Page opened, searching vacancies");
        recruitmentVacPage.searchVacancies("QA Lead", "Senior QA Lead", "Odis Adalwin", "Active");
        String resultStatus = recruitmentVacPage.searchResult();

        if(resultStatus=="No Records Found"){
            Log.info(resultStatus);
            Assert.assertEquals(resultStatus, "No Records Found");
        }
        else if(resultStatus.contains("Record Found")){
            Log.info(resultStatus);
            String jobTitle = recruitmentVacPage.getJobTitleResult();
            Assert.assertEquals(jobTitle, "QA Lead");
            Log.info(jobTitle);
            String vacancy = recruitmentVacPage.getVacancyResult();
            Assert.assertEquals(vacancy, "Senior QA Lead");
            Log.info(vacancy);
            Log.info("Test Case Passed");
        }
        Log.endTestCase("searchVacancyTest");
    }

}
