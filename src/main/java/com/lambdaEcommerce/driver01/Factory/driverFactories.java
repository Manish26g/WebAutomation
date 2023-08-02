package com.lambdaEcommerce.driver01.Factory;

import com.lambdaEcommerce.config.BrowserStackConfig01;
import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.enums.BrowserType;
import com.lambdaEcommerce.enums.RunModeType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static com.lambdaEcommerce.config.factory.FrameworkConfigFactory.getConfig02;
import static com.lambdaEcommerce.config.factory.BrowserStackConfigFactory.getConfig01;

public final class driverFactories {

    public static WebDriver getDriver(String browserName) throws MalformedURLException {
        WebDriver driver= null;

        String runmode= getConfig02().browserRunMode();
        if(runmode.equalsIgnoreCase("browserstack")){
            driver=browserStackDriver(browserName);
        }else if(runmode.equalsIgnoreCase("selenoid")){
            driver=selenoidDriver(browserName);
        } else if (runmode.equalsIgnoreCase("local")){
            driver=localDriver(browserName);
        }
        return driver;
    }


    public static WebDriver localDriver(String browserName){
        WebDriver localDriver= null;
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                localDriver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                localDriver= new FirefoxDriver();
                break;
        }
        return localDriver;
    }


    public static WebDriver browserStackDriver(String browserName) throws MalformedURLException {
        WebDriver browserStackDriver= null;

        MutableCapabilities capabilities= new MutableCapabilities();
        capabilities.setCapability("browser", browserName);
        HashMap<String, Object> browserstackOptions= new HashMap<>();
        browserstackOptions.put("pojectName","LambdaEcommerce Automation");
        capabilities.setCapability("bstack:options",browserstackOptions);
        /*browserStackDriver=new RemoteWebDriver
                (new URL("https://"+browserstack_username+" :"+ browserstack_access_key
                        + "@hub-cloud.browserstack.com/wd/hub"), capabilities);*/
        return new RemoteWebDriver(new URL(getConfig01().browserStackURL()),capabilities);

    }


    public static WebDriver selenoidDriver(String browserName) throws MalformedURLException {
        WebDriver selenoiddriver= null;
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("browserName",browserName);

        return new RemoteWebDriver(new URL(getConfig02().selenoidURL()),capabilities);
    }


}
