package com.lambdaEcommerce.driver.manager.web.remote.selenium;


import com.lambdaEcommerce.enums.BrowserType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


import static com.lambdaEcommerce.config.factory.FrameworkConfigFactory.getConfig01;

public final class SeleniumGridChromeManager {

    private SeleniumGridChromeManager(){}

    @SneakyThrows
    public static WebDriver getDriver() {

        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setBrowserName(String.valueOf(BrowserType.CHROME));
        return new RemoteWebDriver(getConfig01().seleniumGridURL(), capabilities);

    }


}
