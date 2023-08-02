package com.lambdaEcommerce.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.lambdaEcommerce.driver01.Manager.driverManager;
import com.lambdaEcommerce.enums.AuthorType;
import com.lambdaEcommerce.enums.CategoryType;
import com.lambdaEcommerce.pages.base.WebUI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.lambdaEcommerce.utils.screenshots.ScreenshotUtils.getScreenShot;

public final class ExtentReport  {

    private ExtentReport(){}

    public static ExtentReports extentReports;

    public static ExtentReports initReports(){
        extentReports= new ExtentReports();
        ExtentSparkReporter spark= new ExtentSparkReporter(System.getProperty("user.dir")+ "/ExtentReports/"
                +System.currentTimeMillis() + ".png");
        extentReports.attachReporter(spark);

        spark.config().setTheme(Theme.STANDARD);
        spark.config().setReportName("UI_Automation_Report");
        spark.config().setDocumentTitle("Lambda-Ecommerce_Application");

        return extentReports;

    }

    public static void flushReports(){
            extentReports.flush();
            ExtentManager.unload();
    }



    public static void addAuthors(AuthorType[] authorTypes){
        for(AuthorType authorType: authorTypes){
           ExtentManager.getExtentTest().assignAuthor(authorTypes.toString());
        }
    }

    public static void addCategories(CategoryType[] categoryTypes){
        for(CategoryType categoryType: categoryTypes){
            ExtentManager.getExtentTest().assignCategory(categoryTypes.toString());
        }
    }

    public static void addScreenShot(Status status) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        //Base64 from Screenshot of Selenium
        //ExtentTestManager.getExtentTest().log(status, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

        //File Path from Screenshot of Java
        ExtentManager.getExtentTest().log(status , MediaEntityBuilder.createScreenCaptureFromPath(WebUI.TakeScreenshot()).build());

    }

    public static void logMessage(String message) {
        ExtentManager.getExtentTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        ExtentManager.getExtentTest().log(status, message);
    }



}
