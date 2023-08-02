package com.lambdaEcommerce.driver.factories.web.remote;

import com.lambdaEcommerce.enums.BrowserRemoteModeType;
import com.lambdaEcommerce.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}

    private static final Map<BrowserRemoteModeType, Function<BrowserType, WebDriver>> MAP=
            new EnumMap<>(BrowserRemoteModeType.class);

    static{
        MAP.put(BrowserRemoteModeType.SELENIUM, SeleniumGridFactory::getDriver);
    }

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType driverType){
            return MAP.get(browserRemoteModeType).apply(driverType);
    }
}
