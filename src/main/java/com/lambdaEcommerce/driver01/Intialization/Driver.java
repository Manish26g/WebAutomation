package com.lambdaEcommerce.driver01.Intialization;

import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.driver01.Factory.driverFactories;

import com.lambdaEcommerce.driver01.Manager.driverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;
import static com.lambdaEcommerce.config.factory.FrameworkConfigFactory.getConfig02;

public final class Driver {

    private Driver(){}

    /*public static void initDriver(String browser) throws MalformedURLException {
        if(Objects.isNull(DriverManager.getDriver())){
             DriverManager.setDriver(driverfactories.getDriver(browser));
             //DriverManager.getDriver().manage().window().maximize();
             DriverManager.getDriver().get(getConfig02().webUrl());
        }

    }*/

    public static void initDriver() throws MalformedURLException {
      String browser= FrameworkConfigFactory.getConfig02().browser();
      if(driverManager.getDriver()== null){
          driverManager.setDriver(driverFactories.getDriver(browser));
          driverManager.getDriver().manage().window().maximize();
          driverManager.getDriver().get(getConfig02().webUrl());
      }

    }

    public static void initCrossBrowserDriver(String browser) throws MalformedURLException {
       if(driverManager.getDriver()== null){
           driverManager.setDriver(driverFactories.getDriver(browser));
           driverManager.getDriver().manage().window().maximize();
           driverManager.getDriver().get(getConfig02().webUrl());
        }

    }

    public static void quitDriver(){
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.unload();
        }
    }
}
