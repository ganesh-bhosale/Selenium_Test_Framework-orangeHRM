package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    public DashboardPage(){
        super();
    }

    // Page Locators
    By DashboardTitle = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6");
    By userDropdown = By.cssSelector(".oxd-userdropdown-name");
    By logoutButton = By.xpath("//a[@href=\"/web/index.php/auth/logout\"]");
    By recruitmentMenu = By.xpath("//ul[@class=\"oxd-main-menu\"]/li[5]/a");
    By vacienciesButton = By.xpath("//a[text()=\"Vacancies\"]");

    public String getDashboardPageTitle(){
        waitForVisibilityOfElement(DashboardTitle);
        return getText(DashboardTitle);
    }

    public void doLogout(){
        click(userDropdown);
        waitForElementToBeClickable(logoutButton);
        click(logoutButton);
    }

    public RecruitmentVacPage openRecruitmentPage(){
        click(recruitmentMenu);
        waitForVisibilityOfElement(vacienciesButton);
        return new RecruitmentVacPage();
    }

    public RecruitmentCanPage openRecruitmentCanPage(){
        click(recruitmentMenu);
        waitForVisibilityOfElement(vacienciesButton);
        return new RecruitmentCanPage();
    }

}
