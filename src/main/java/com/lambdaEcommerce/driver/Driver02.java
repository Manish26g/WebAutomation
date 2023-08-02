package com.lambdaEcommerce.driver;

import com.lambdaEcommerce.driver.entity.DriverData;
import com.lambdaEcommerce.driver.factories.DriverFactory02;
import com.lambdaEcommerce.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.lambdaEcommerce.config.factory.FrameworkConfigFactory.getConfig01;

public class Driver02 {

    private Driver02(){}


    /*//static WebDriver driver= null;
    public static void initDriver(){ //LocalDriverFactory
        //WebDriver driver= LocalDriverFactory01.getDriver();

        WebDriver driver= LocalDriverFactory01.getDriver(getConfig01().browser());


        driver.get("https://www.google.com");

        *//*if(FrameworkConfigFactory.getConfig01().browser() == BrowserType.CHROME){
            driver= new ChromeDriver();
            driver.get("https://www.google.com");
        }
        else{
            driver= new FirefoxDriver();
            driver.get("https://www.google.com");
        }*//*
    }*/


    /*public static void initDriverforWeb(){
        DriverData driverData= DriverData.builder()
                .browserType(getConfig01().browser())
                .browserRemoteModeType(getConfig01().browserRemoteMode())
                .runModeType(getConfig01().browserRunMode())
                .build();
        WebDriver driver= DriverFactory02.getDriverForWeb(driverData);
        driver.quit();
    }*/

    public static void initDriverforWeb(){
        if(Objects.isNull(DriverManager.getDriver())) {
            if(getConfig01().browser()== BrowserType.CHROME){
                DriverData driverData = new DriverData(getConfig01().browser(),
                        getConfig01().browserRemoteMode(), getConfig01().browserRunMode());
                WebDriver driver = DriverFactory02.getDriverForWeb(driverData);
                DriverManager.setDriver(driver);
                loadURL();
            }
            else{

            }

        }

    }

    public static void loadURL(){
        DriverManager.getDriver().get(getConfig01().webUrl());
    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
