package com.lambdaEcommerce.driver.factories.web.local;

import com.lambdaEcommerce.driver.manager.web.local.ChromeManager;
import com.lambdaEcommerce.driver.manager.web.local.FirefoxManager;
import com.lambdaEcommerce.enums.BrowserType;

import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {

    private LocalDriverFactory(){}

    private static final Map<BrowserType, Supplier<WebDriver>> MAP=
            new EnumMap<>(BrowserType.class);
    static{
      MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
      MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType driverType){
        return MAP.get(driverType).get();
    }


}
