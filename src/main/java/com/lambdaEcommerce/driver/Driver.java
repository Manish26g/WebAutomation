package com.lambdaEcommerce.driver;

import com.lambdaEcommerce.driver.entity.WebDriverData;
import com.lambdaEcommerce.driver.factories.DriverFactory01;
import com.lambdaEcommerce.enums.RunModeType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;


import static com.lambdaEcommerce.driver.factories.DriverFactory01.getDriverforWeb;


/*public final class Driver {

    private Driver(){}

    public static void initDriverForWeb(){
        if(Objects.isNull(DriverManager.getDriver())){
            WebDriverData driverData= new WebDriverData(getConfig().browser());

            //WebDriver driver= DriverFactory01.getDriverforWeb(getRunModeType()).getDriver(driverData);


            WebDriver driver01= DriverFactory01.getDriverforWeb(getConfig().runModeLocal()).getDriver(driverData);

            //WebDriver driver= getDriverforWeb(getRunModeType()).getDriver(driverData);
            DriverManager.setDriver(driver01);
            //DriverManager.setDriver(DriverFactory.getDriver(driverData));
             DriverManager.getDriver().manage().window().maximize();
             loadURL();

        }
    }

    *//*private static RunModeType getRunModeType() {
        return RunModeType.valueOf(getConfig().runModeLocal().toUpperCase());
    }*//*

    public static void loadURL(){
        DriverManager.getDriver().get(getConfig().webUrl());
    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }




}*/
