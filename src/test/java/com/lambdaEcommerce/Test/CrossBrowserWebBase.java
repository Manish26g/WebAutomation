package com.lambdaEcommerce.Test;

import com.lambdaEcommerce.driver01.Intialization.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class CrossBrowserWebBase {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException {
        Driver.initCrossBrowserDriver(browser);
    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }


}
