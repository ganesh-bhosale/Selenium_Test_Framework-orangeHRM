package com.orangehrm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitForHelper {

    public WebDriver driver = DriverManagerTL.getDriver();

    public WaitForHelper(WebDriver driver){
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10));
    public WebElement presenceOfElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement elementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement visibilityOfElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> visibilityOfAllElements(By locator){
        // List<WebElement> elements = DriverManagerTL.getDriver().findElements(locator);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public Boolean inVisibilityOfElement(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Boolean invisibilityOfAllElements(By locator){
        List<WebElement> element = DriverManagerTL.getDriver().findElements(locator);
        return wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
    public Boolean textToBePresentInElement(By locator, String text){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }



}
