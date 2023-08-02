package com.lambdaEcommerce.driver.manager.web.remote.selenium;


import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.enums.BrowserType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridFirefoxManager01 {

    private SeleniumGridFirefoxManager01(){}

    @SneakyThrows
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(String.valueOf(BrowserType.FIREFOX));
        return new RemoteWebDriver(FrameworkConfigFactory.getConfig01().seleniumGridURL(), capabilities);




    }


}
