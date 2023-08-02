package com.lambdaEcommerce.driver.factories.web.remote;

import com.lambdaEcommerce.driver.IWebDriver;
import com.lambdaEcommerce.driver.entity.DriverData;
import com.lambdaEcommerce.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public class RemoteDriverImpl implements IWebDriver {
    @Override
    public WebDriver getDriver(DriverData driverData) {
        return RemoteDriverFactory01.getDriver(driverData.getBrowserRemoteModeType(),driverData.getBrowserType());
    }

    /*@Override
    public WebDriver getDriver(WebDriverData driverData) {
        return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(),driverData.getDriverType());
    }*/
}
