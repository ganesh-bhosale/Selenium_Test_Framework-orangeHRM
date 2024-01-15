package com.orangehrm.base;

import com.orangehrm.utils.DriverManagerTL;
import com.orangehrm.utils.Log;
import com.orangehrm.utils.PropertyReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeClass
    protected void setUp() throws Exception {
        DriverManagerTL.init();
        Log.TestExecutionStart();
    }


    public void navigateToURL() throws Exception {
        try{
            DriverManagerTL.getDriver().get(PropertyReader.readKey("applicationURL"));
        }
        catch (Exception e){
            Log.error("Unable to navigate URL");
        }
    }

    @AfterClass
    protected void tearDown() throws Exception {
        DriverManagerTL.tearDown();
        Log.TestExecutionEnd();
    }




}
