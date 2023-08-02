package com.lambdaEcommerce.driver.factories.web.local;

import com.lambdaEcommerce.driver.IWebDriver;
import com.lambdaEcommerce.driver.entity.WebDriverData;
import com.lambdaEcommerce.driver.entity.DriverData;
import org.openqa.selenium.WebDriver;

public class LocalDriverImpl implements IWebDriver {

    //@Override
    /*public WebDriver getDriver(WebDriverData driverData) {
        return LocalDriverFactory.getDriver(driverData.getDriverType());
    }*/



    /*@Override
    public WebDriver getDriver(DriverData driverData) {
        return LocalDriverFactory01.getDriver(driverData.getBrowserType());
    }*/

    @Override
    public WebDriver getDriver(DriverData driverData) {
        //return LocalDriverFactory01.getDriver(driverData.getBrowserType());
        return LocalDriverFactory02.getDriver(driverData.getBrowserType());
    }

}
