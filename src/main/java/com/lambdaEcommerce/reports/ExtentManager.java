package com.lambdaEcommerce.reports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports report;
    
    public static ExtentReports getInstance(){
        if(report==null){
            ExtentSparkReporter spark= new ExtentSparkReporter(System.getProperty("user.dir")+ "/ExtentReports/"
                    +System.currentTimeMillis() + ".jpg");
            report= new ExtentReports();
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("UI_Automation_ExtentReport");

            report.attachReporter(spark);

        }
        return report;
    }
}
