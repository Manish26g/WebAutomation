package com.lambdaEcommerce.driver.factories.web.remote;

import com.lambdaEcommerce.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.lambdaEcommerce.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class BrowserStackFactory {

    private BrowserStackFactory(){}

    private static final Map<BrowserType, Supplier<WebDriver>> MAP= new EnumMap<>(BrowserType.class);

    static{
             MAP.put(BrowserType.CHROME, BrowserStackChromeManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType driverType){
        return MAP.get(driverType).get();
    }

}
