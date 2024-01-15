package com.orangehrm.utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverManagerTL {

    static WebDriver driver;

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void unload(){
        dr.remove();
    }

    @BeforeSuite
    public static void init() throws Exception{
        if(getDriver()==null){
            try{
                startBrowser(PropertyReader.readKey("browser"));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static WebDriver startBrowser(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
         // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--disable-notifications");
            setDriver(new ChromeDriver(options));
            getDriver().manage().window().maximize();
        }

        else if (browserName.equalsIgnoreCase("edge")){
         // System.setProperty("webdriver.edge.driver", "path/to/edgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            setDriver(new EdgeDriver(options));
        }

        else if(browserName.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            setDriver(new FirefoxDriver(options));
            getDriver().manage().window().maximize();
        }

        return getDriver();
    }

    @AfterSuite
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            unload();
        }
    }
}
