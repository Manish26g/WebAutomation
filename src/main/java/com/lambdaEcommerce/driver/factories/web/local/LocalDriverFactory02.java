package com.lambdaEcommerce.driver.factories.web.local;

import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverFactory02 {

    private LocalDriverFactory02(){}

    public static WebDriver getDriver(BrowserType browserType){
        WebDriver driver= null;
        if(FrameworkConfigFactory.getConfig01().browser() == BrowserType.CHROME){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else{
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;

    }









}
