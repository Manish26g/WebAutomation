package com.lambdaEcommerce.Test;



import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.lambdaEcommerce.driver01.Intialization.Driver;
import com.lambdaEcommerce.reports.ExtentManager;
import com.lambdaEcommerce.reports.ExtentReports;
import com.lambdaEcommerce.reports.screenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;



public class WebBase {

    WebDriver driver;

    @BeforeMethod
    public void setUpSparktest(ITestResult result){
        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
        ExtentReports.setExtentTest(test);
    }


     /*@AfterMethod
     public void SparkTestResult(ITestResult result) throws IOException {
         if(!result.isSuccess()){
             ExtentReports.getExtentTest().log(Status.FAIL, "test case failed as"+ result.getThrowable());
             String path= screenShot.getScreenshot(result.getMethod().getMethodName()+ ".jpg");
             ExtentReports.getExtentTest().fail(MediaEntityBuilder.
                     createScreenCaptureFromBase64String(screenShot.convertImg_Base64(path)).build());

         }
     }*/

    //@BeforeMethod
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Driver01.initDriverforWeb();
        Driver.initDriver();
        //maximizeWindow();
        //waitForPageLoaded();

    }

    //@AfterMethod
    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }

    @AfterSuite
    public void sparkFlush(){
         ExtentManager.getInstance().flush();
    }
}
