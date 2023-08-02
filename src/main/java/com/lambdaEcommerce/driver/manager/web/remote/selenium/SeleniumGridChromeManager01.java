package com.lambdaEcommerce.driver.manager.web.remote.selenium;


import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.enums.BrowserType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;



public final class SeleniumGridChromeManager01 {

    private SeleniumGridChromeManager01(){}

    @SneakyThrows
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(String.valueOf(BrowserType.CHROME));
        return new RemoteWebDriver(FrameworkConfigFactory.getConfig01().seleniumGridURL(), capabilities);




    }


}
