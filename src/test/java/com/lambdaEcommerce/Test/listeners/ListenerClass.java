package com.lambdaEcommerce.Test.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.lambdaEcommerce.Test.WebBase;
import com.lambdaEcommerce.reports.ExtentReports;
import com.lambdaEcommerce.reports.screenShot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerClass extends WebBase implements ITestListener {

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
        if(!result.isSuccess()){
            ExtentReports.getExtentTest().log(Status.FAIL, "test case failed as"+ result.getThrowable());
            String path= null;
            path = screenShot.getScreenshot(result.getMethod().getMethodName()+ ".jpg");
            try {
                ExtentReports.getExtentTest().fail(MediaEntityBuilder.
                        createScreenCaptureFromBase64String(screenShot.convertImg_Base64(path)).build());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }



}
