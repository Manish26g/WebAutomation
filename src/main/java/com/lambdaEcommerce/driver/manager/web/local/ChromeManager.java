package com.lambdaEcommerce.driver.manager.web.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public final class ChromeManager {

    private ChromeManager(){}

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
       return new ChromeDriver();


     }




}
