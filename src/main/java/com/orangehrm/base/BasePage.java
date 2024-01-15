package com.orangehrm.base;

import com.beust.ah.A;
import com.orangehrm.utils.DriverManagerTL;
import com.orangehrm.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;

public class BasePage {

    protected BasePage(){
    }

    // Navigate to url
    public void getURL(String url){
        DriverManagerTL.getDriver().get(url);
    }

    public void navigateToURL(String url){
        DriverManagerTL.getDriver().navigate().to(url);
    }

    // Get Title
    public String getPageTitle(){
        return DriverManagerTL.getDriver().getTitle();
    }

    // Click webElement

    public void click(By locator){
        DriverManagerTL.getDriver().findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }

    // Enter text in element
    public void inputText(By locator, String text){
        DriverManagerTL.getDriver().findElement(locator).clear();
        DriverManagerTL.getDriver().findElement(locator).sendKeys(text);
    }

    public void inputText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void clearTextBox(By locator){
        DriverManagerTL.getDriver().findElement(locator).clear();
    }

    // Read\Get Text from Element
    public String getText(By locator){
        return DriverManagerTL.getDriver().findElement(locator).getText();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    // Upload a file
    public void uploadFile(By locator, String filePath){
        DriverManagerTL.getDriver().findElement(locator).sendKeys(filePath);
    }

    public void uploadFile(WebElement element, String filePath){
        element.sendKeys(filePath);
    }

    // Dropdown values selections
    public void dropdownSelectByValue(By locator, String value){
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void dropdownSelectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectOptionFromDropdown(By locator, String option){
        List<WebElement> elementsList = DriverManagerTL.getDriver().findElements(locator);

        for(WebElement options : elementsList){
            if(options.getText().equals(option)){
                options.click();
                break;
            }
        }
    }

    public void getAllElementValues(By locator){
        List<WebElement> elements = DriverManagerTL.getDriver().findElements(locator);
        for(WebElement element: elements){
            String value = element.getText();
            System.out.println(value);
        }
    }

    // Actions Class Method
    public void moveToElement(By locator){
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element);
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element);
    }

    public void moveToElementAndClick(By locator){
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element).click();
    }

    public void moveToElementAndClick(WebElement element){
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element).click();
    }

    public void moveToElementAndInputText(By locator, String text){
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element).sendKeys(text);
    }

    public void moveToElementAndInputText(WebElement element, String text){
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element).sendKeys(text);
    }

    public void enterKeyAndSelectFromOptions(By locator1, String key, By locator2, String option){
        WebElement element = DriverManagerTL.getDriver().findElement(locator1);
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element).sendKeys(key).perform();
        waitForVisibilityOfAllElements(locator2);
        List<WebElement> elements = DriverManagerTL.getDriver().findElements(locator2);
        for(WebElement options : elements){
            if(options.getText()==option){
                options.click();
            }
        }
    }

    public int getElementsSize(By locator){
        return DriverManagerTL.getDriver().findElements(locator).size();
    }

    // WebDriver Wait Methods
     WaitForHelper waitForHelper = new WaitForHelper(DriverManagerTL.getDriver());
    public void waitForPresentOfElement(By locator){
        waitForHelper.presenceOfElement(locator);
    }

    public void waitForElementToBeClickable(By locator){
        waitForHelper.elementToBeClickable(locator);
    }

    public void waitForVisibilityOfElement(By locator){
        waitForHelper.visibilityOfElement(locator);
    }

    public void waitForVisibilityOfAllElements(By locator){
        waitForHelper.visibilityOfAllElements(locator);
    }

    public void waitForInVisibilityOfElement(By locator){
        waitForHelper.inVisibilityOfElement(locator);
    }

    public void waitForInvisibilityOfAllElements(By locator){
        waitForHelper.invisibilityOfAllElements(locator);
    }

    public void waitForTextToBePresentInElement(By locator){
        waitForHelper.inVisibilityOfElement(locator);
    }
}
