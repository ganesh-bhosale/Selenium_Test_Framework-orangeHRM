package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class RecruitmentVacPage extends BasePage {
    public RecruitmentVacPage(){
        super();
    }

    By vacienciesButton = By.xpath("//a[text()=\"Vacancies\"]");
    By jobTitleDrpdwn = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]/div//div[2]/div");
    By jobTitleOptions = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]/div/div[2]/div/div[2]/div/span");
    By vacancydrpdwn = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div//div[2]/div");
    By vacancyOptions = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div/div[2]/div/div[2]/div/span");
    By hiringManagerDrpdwn = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[3]/div//div[2]/div");
    By hiringManagerOptions = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[3]/div/div[2]/div/div[2]/div/span");
    By statusDrpdwn = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]/div//div[2]/div");
    By statusOptions = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]/div/div[2]/div/div[2]/div/span");
    By searchButton = By.xpath("//button[@type='submit']");
    By resetButton = By.xpath("//div[@class='oxd-form-actions']/button[1]");
    By recordsResult = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span");
    By vacanyResult = By.xpath("//div[@class='oxd-table-card']/div/div[2]/div");
    By jobTitleResult = By.xpath("//div[@class='oxd-table-card']/div/div[3]/div");
    By addVacancyButton = By.xpath("//div/div/button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By vacancyNameInput = By.xpath("//div[1][@class='oxd-grid-3 orangehrm-full-width-grid']/div/div/div[2]/input");
    By jobTitleDrpdwn2 = By.xpath("//div/div[@class='oxd-select-wrapper']/div/div[1]");
    By jobTitleOptions2 = By.xpath("//div/div[@class='oxd-select-wrapper']/div[2]/div");
    By descriptionBox = By.xpath("//div/textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    By hiringManagerBox = By.xpath("//input[@placeholder='Type for hints...']");
    By hiringManagerBoxOptions =By.xpath("//div[@class='oxd-autocomplete-wrapper']/div[2]/div/span");
    By noOfPositionBox = By.xpath("//div[3][@class='oxd-grid-3 orangehrm-full-width-grid']/div[2]/div/div/div/div[2]/input");
    By saveButton = By.xpath("//button[@type='submit']");
    By successMsg = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']/p[2]");





    public void clickVacanciesButton(){
        click(vacienciesButton);
        waitForVisibilityOfElement(jobTitleDrpdwn);
    }

    public void selectJobTitle(String jobTitle){
        click(jobTitleDrpdwn);
        waitForVisibilityOfAllElements(jobTitleOptions);
        selectOptionFromDropdown(jobTitleOptions, jobTitle);
        // waitForInvisibilityOfAllElements(jobTitleOptions);
    }

    public void selectVacancy(String vacancy){
        click(vacancydrpdwn);
        waitForVisibilityOfAllElements(vacancyOptions);
        selectOptionFromDropdown(vacancyOptions, vacancy);
        // waitForInvisibilityOfAllElements(vacancyOptions);
    }

    public void selectHiringManager(String manager){
        click(hiringManagerDrpdwn);
        waitForVisibilityOfAllElements(hiringManagerOptions);
        selectOptionFromDropdown(hiringManagerOptions, manager);
        // waitForInvisibilityOfAllElements(hiringManagerOptions);
    }

    public void selectStatus(String status){
        click(statusDrpdwn);
        waitForVisibilityOfAllElements(statusOptions);
        selectOptionFromDropdown(statusOptions, status);
        // waitForInvisibilityOfAllElements(statusOptions);
    }

    public void clickSearchButton(){
        click(searchButton);
    }

    public void clickResetButton(){
        click(resetButton);
    }

    public void searchVacancies(String jobTitle, String vacancy, String manager, String status){
        clickVacanciesButton();
        selectJobTitle(jobTitle);
        selectVacancy(vacancy);
        selectHiringManager(manager);
        selectStatus(status);
        clickSearchButton();
        waitForVisibilityOfElement(recordsResult);
    }

    public String searchResult(){
        waitForVisibilityOfElement(recordsResult);
        return getText(recordsResult);
    }

    public String getJobTitleResult(){
        return getText(jobTitleResult);
    }

    public String getVacancyResult(){
        return getText(vacanyResult);
    }

    public void clickAddVacancyButton(){
        click(addVacancyButton);
        waitForVisibilityOfElement(vacancyNameInput);
    }

    public void addVacancy(String vacancyName, String jobTitle, String description, String hiringManagerName, String noOfPos){
        clickVacanciesButton();
        clickAddVacancyButton();
        inputText(vacancyNameInput, vacancyName);
        click(jobTitleDrpdwn2);
        waitForVisibilityOfAllElements(jobTitleOptions2);
        selectOptionFromDropdown(jobTitleOptions2, jobTitle);
        inputText(descriptionBox, description);
        enterKeyAndSelectHiringManager(hiringManagerName);
        inputText(noOfPositionBox, noOfPos);
        click(saveButton);
    }

    public void enterKeyAndSelectHiringManager(String hrManager){
        inputText(hiringManagerBox, hrManager);
        waitForVisibilityOfAllElements(hiringManagerBoxOptions);
        selectOptionFromDropdown(hiringManagerBoxOptions, hrManager);
    }


}
