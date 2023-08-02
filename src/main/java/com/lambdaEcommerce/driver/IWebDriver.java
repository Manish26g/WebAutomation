package com.lambdaEcommerce.driver;

import com.lambdaEcommerce.driver.entity.DriverData;
import com.lambdaEcommerce.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
    //WebDriver getDriver(WebDriverData driverData);
    WebDriver getDriver(DriverData driverData);
}
