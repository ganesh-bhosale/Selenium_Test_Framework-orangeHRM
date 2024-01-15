package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import com.orangehrm.utils.Log;
import com.orangehrm.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RecruitmentCanPage extends BasePage {
    By candidatesButton = By.xpath("//li[@class='oxd-topbar-body-nav-tab --visited']");
    By candidatePageHeader = By.xpath("//div[@class='oxd-table-filter-header-title']");
    By vacancyFilter = By.xpath("//div[@class='oxd-form-row'][1]/div/div[2]/div/div[2]");
    By vacancyFilterOptions = By.xpath("//div[@role='listbox']/div/span");
    By candidateNameBox = By.cssSelector("input[placeholder='Type for hints...']");
    By candidateAutoSuggestions = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div/span");
    By searchButton = By.cssSelector("button[type='submit']");
    By searchResultMsg = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span");
    By addCandidateButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By firstNameBox = By.name("firstName");
    By middleNameBox = By.name("middleName");
    By lastNameBox = By.name("lastName");
    By vacancyDrpDwn = By.xpath("//div[@class='oxd-form-row'][2]/div/div/div/div[2]");
    By vacancyOptions = By.xpath("//div[@class='oxd-select-wrapper']/div[2]/div/span");
    By emailBox = By.xpath("//div[@class='oxd-form-row'][3]/div/div/div/div[2]/input");
    By contactNumberBox = By.xpath("//div[@class='oxd-form-row'][3]/div/div[2]/div/div[2]/input");
    By resumeUpload = By.className("oxd-file-input");
    By keywordsBox = By.xpath("//input[@placeholder='Enter comma seperated words...']");
    By dateField = By.xpath("//div[@class='oxd-date-input']/input");
    By consentCheckBox = By.cssSelector("i[class='oxd-icon bi-check oxd-checkbox-input-icon']");
    By saveButton = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    By applicationFormHeader = By.xpath("//form/h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    By applicationFormName = By.xpath("//div[@class='orangehrm-card-container']/form/div[1]/div[1]/div/div[2]/p");
    By applicationFormStatus = By.xpath("//div[@class='orangehrm-recruitment-status']/p");
    By recordsResult = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span");
    By tableRow = By.xpath("//div[@class='oxd-table-body']/div/div");
    By tableRowCol = By.xpath("//div[@class='oxd-table-body']/div[1]/div/div");
    By tableCol = By.xpath("//div[@class='oxd-table-body']/div/div/div");
    By eyeButton = By.xpath("//div[@class='oxd-table-body']/div/div/div[7]/div/button[1]/i");



    public void clickCandidateButton(){
        click(candidatesButton);
        waitForVisibilityOfElement(candidatePageHeader);
        waitForVisibilityOfElement(recordsResult);
    }

    public void selectVacancyFromDropdown(String vacanyName){
        click(vacancyDrpDwn);
        waitForVisibilityOfAllElements(vacancyOptions);
        selectOptionFromDropdown(vacancyOptions, vacanyName);
    }

    public void selectDateField(String date){
        inputText(dateField, date);
    }
    public void uploadResume() throws Exception {
        inputText(resumeUpload, PropertyReader.readKey("resumePath"));
    }
    public void addCandidate(String firstName, String middleName, String lastName, String vacancy, String email, String contactNo, String keywords, String date) throws Exception {
        clickCandidateButton();
        click(addCandidateButton);
        waitForVisibilityOfElement(firstNameBox);
        inputText(firstNameBox, firstName );
        inputText(middleNameBox, middleName);
        inputText(lastNameBox, lastName);
        selectVacancyFromDropdown(vacancy);
        inputText(emailBox, email);
        inputText(contactNumberBox, contactNo);
        // uploadResume();
        inputText(keywordsBox, keywords);
        // selectDateField(date);
        click(consentCheckBox);
        click(saveButton);
        waitForVisibilityOfElement(applicationFormHeader);
    }

    public String getApplicationFormCanName(){
        waitForVisibilityOfElement(applicationFormName);
        return getText(applicationFormName);
    }
    public String getApplicationFormStatus(){
        waitForVisibilityOfElement(applicationFormStatus);
        return getText(applicationFormStatus);
    }

    public void searchCandidate(String nameHint, String fullName, String vacancy){
        click(candidatesButton);
        waitForVisibilityOfElement(candidatePageHeader);
        click(vacancyFilter);
        waitForVisibilityOfAllElements(vacancyFilterOptions);
        selectOptionFromDropdown(vacancyFilterOptions, vacancy);
        inputText(candidateNameBox, nameHint);
        waitForVisibilityOfAllElements(candidateAutoSuggestions);
        selectOptionFromDropdown(candidateAutoSuggestions, fullName);
        click(searchButton);
        waitForVisibilityOfElement(searchResultMsg);
        String searchResult = getText(searchResultMsg);

        if(searchResult.equals("No Records Found")){
            Log.info("Candidate Found!");
        }
        else{
         Log.warn("Candidate Not Found!");
        }
    }

    public List<String> getCandidateNames(){
        List<String> candidateNames = new ArrayList<>();

        int row = getElementsSize(tableRow);
        int col = getElementsSize(tableRowCol);

        String part1 = "//div[@class='oxd-table-body']/div[";
        String part2 = "]/div/div[3]";

        for(int i=1;i<=row;i++){
            String dynamicPath = part1+i+part2;
            By dynamicXpathCanName = By.xpath(dynamicPath);
            String name = getText(dynamicXpathCanName);
            candidateNames.add(name);
        }

        return candidateNames;
    }

    public String getCandidateStatus(String candidateName){
        List<String> candidateNamesList = getCandidateNames();
        String candidateStatus = "";

        String part1 = "//div[@class='oxd-table-body']/div[";
        String part2 = "]/div/div[6]";

        for(int i=0; i<candidateNamesList.size();i++){
            String name = candidateNamesList.get(i);
            if(name.equals(candidateName)){
                String dynamicPath = part1+(i+1)+part2;
                By canStatus = By.xpath(dynamicPath);
                candidateStatus = getText(canStatus);
                break;
            }
        }
        return candidateStatus;
    }


    public void shortListCandidate(String nameHint, String canName, String vacancy){
        searchCandidate(nameHint, canName, vacancy);
        String status = getCandidateStatus(canName);

        if(status.equals("Application Initiated")){
            click(eyeButton);
            waitForVisibilityOfElement(applicationFormHeader);
            Log.info(getText(applicationFormStatus));


        }
        else if(status.equals("Shortlisted")){

        }
        else if(status.equals("Interview Scheduled")){

        }
        else if(status.equals("Interview Passed")){

        }
        else if(status.equals("Job Offered")){

        }
        else if(status.equals("Hired")){

        }
        else if(status.equals("Interview Failed")){

        }
        else if(status.equals("Rejected")){

        }
    }

}
