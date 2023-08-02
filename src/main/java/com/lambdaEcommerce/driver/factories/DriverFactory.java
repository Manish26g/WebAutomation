package com.lambdaEcommerce.driver.factories;


import com.lambdaEcommerce.config.factory.BrowserStackConfigFactory;
import com.lambdaEcommerce.driver.entity.WebDriverData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;



/*@Slf4j
public class DriverFactory {

    private DriverFactory() {
    }

    //private static final org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver getDriver(WebDriverData driverData){
         WebDriver driver= null;

         String runmode= getConfig().runModeLocal();
         if(runmode.equalsIgnoreCase("browserstack")){
            driver= browserStackDriver();
         }else if(runmode.equalsIgnoreCase("selenoid")){
             driver=selenoidDriver();
         } else if(runmode.equalsIgnoreCase("local")){
             driver=localDriver();
         }
        return driver;
    }

    @SneakyThrows
    private static WebDriver browserStackDriver(){
        //log.info("Browser is: " + browserName);
        log.info("Will run test in BrowserStack" );
        WebDriver browserstackdriver= null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browser",browserName);
        capabilities.setCapability("enableVideo", false);
        return new RemoteWebDriver(new URL(BrowserStackConfigFactory.getConfig().browserStackURL()),capabilities);

    }

    @SneakyThrows
    private static WebDriver selenoidDriver(){
        //log.info("Browser is: " + browserName);
        log.info("Will run test in selenoidDriver" );
        WebDriver selenoiddriver= null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browser",browserName);
        capabilities.setCapability("enableVideo", false);
        return new RemoteWebDriver(new URL(getConfig().selenoidURL()),capabilities);

    }

    private static WebDriver localDriver() {

        //log.info("Browser is: " + browserName);
        log.info("Will run test in Local");

        WebDriver localdriver = null;
        switch (browserName) {
            case "chrome":
                // Removing WebdriverManager since we do not require this after selenium: 4.6
                // WebDriverManager.chromedriver().setup();
                localdriver = new ChromeDriver();
                log.info("Chrome driver launched");
                break;
            case "firefox":
                // Removing WebdriverManager since we do not require this after selenium: 4.6
                // WebDriverManager.firefoxdriver().setup();
                localdriver = new FirefoxDriver();
                log.info("Firefox driver launched");
                break;
            default:
                log.info("No browser selected. Please select one");
                break;
        }
        return localdriver;
    }

    public static WebDriver localdriver(DriverType driverType){

        WebDriver LD = null;

        switch (driverType){
            case CHROME:{
                LD = new ChromeDriver();
                log.info("Chrome driver launched");
            }

            case FIREFOX:{
                LD = new FirefoxDriver();
                log.info("Firefox driver launched");
                break;
            }
            default : throw new IllegalArgumentException("Invalid Driver: " + driverType);
        }
        return LD;


    }










    
}*/
