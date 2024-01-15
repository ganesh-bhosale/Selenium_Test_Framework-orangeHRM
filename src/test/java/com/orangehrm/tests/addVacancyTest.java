package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentVacPage;
import com.orangehrm.utils.Log;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class addVacancyTest extends BaseTest {

    @Test
    @Description("Add vacancy using vacancies fields")
    public void addVacancyTest() throws Exception{
        Log.startTestCase("addVacancyTest");
        navigateToURL();
        RecruitmentVacPage recruitmentVacPage = new LoginPage().loginToOrangeHRM().afterSuccessfulLogin().openRecruitmentPage();
        recruitmentVacPage.addVacancy("Automation Tester", "Support Specialist", "Test Add Vacancy", "Odis Adalwin", "1");
        Log.info("Vacancy added completed");
        Log.endTestCase("addVacancyTest");
    }
}
