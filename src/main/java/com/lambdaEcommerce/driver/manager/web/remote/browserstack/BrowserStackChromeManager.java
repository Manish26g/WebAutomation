package com.lambdaEcommerce.driver.manager.web.remote.browserstack;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.lambdaEcommerce.config.factory.BrowserStackConfigFactory.getConfig;

public final class BrowserStackChromeManager {

    private BrowserStackChromeManager(){}

    @SneakyThrows
    public static WebDriver getDriver(){
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("browser","chrome");
        return new RemoteWebDriver((getConfig().browserStackURL()),capabilities);
    }
}
