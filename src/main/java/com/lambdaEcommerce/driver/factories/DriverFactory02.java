package com.lambdaEcommerce.driver.factories;

import com.lambdaEcommerce.driver.IWebDriver;
import com.lambdaEcommerce.driver.entity.DriverData;
import com.lambdaEcommerce.driver.factories.web.local.LocalDriverFactory01;
import com.lambdaEcommerce.driver.factories.web.local.LocalDriverImpl;
import com.lambdaEcommerce.driver.factories.web.remote.RemoteDriverFactory01;
import com.lambdaEcommerce.driver.factories.web.remote.RemoteDriverImpl;
import com.lambdaEcommerce.enums.RunModeType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory02 {

    private DriverFactory02(){}

    public static WebDriver getDriverForWeb(DriverData driverData){
        return
                driverData.getRunModeType() == RunModeType.LOCAL
                ? new LocalDriverImpl().getDriver(driverData)
                : new RemoteDriverImpl().getDriver(driverData);
    }

}
