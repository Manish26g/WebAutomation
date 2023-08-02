package com.lambdaEcommerce.driver.factories.web.local;

import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.driver.manager.web.local.ChromeManager;
import com.lambdaEcommerce.driver.manager.web.local.FirefoxManager;
import com.lambdaEcommerce.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverFactory01 {

    private LocalDriverFactory01(){}

    /*public static WebDriver getDriver(){
        WebDriver driver= null;
        if(FrameworkConfigFactory.getConfig01().browser() == BrowserType.CHROME){
            //driver= new ChromeDriver();
            driver= ChromeManager.getDriver();
        }
        else{
            driver= new FirefoxDriver();
        }
        return driver;

    }*/

    public static WebDriver getDriver(BrowserType browserType){
        return isBrowser(browserType)? ChromeManager.getDriver(): FirefoxManager.getDriver();
    }

    private static boolean isBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;

    }







}
