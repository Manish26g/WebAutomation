package com.lambdaEcommerce.driver.factories;

import com.lambdaEcommerce.driver.IWebDriver;
import com.lambdaEcommerce.driver.factories.web.local.LocalDriverImpl;
import com.lambdaEcommerce.driver.factories.web.remote.RemoteDriverImpl;
import com.lambdaEcommerce.enums.RunModeType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory01 {

    private DriverFactory01(){}

    private static final Map<RunModeType, Supplier<IWebDriver>> WEB= new EnumMap<>(RunModeType.class);

    static {
       WEB.put(RunModeType.LOCAL, LocalDriverImpl::new);
       WEB.put(RunModeType.REMOTE, RemoteDriverImpl::new);
    }

    public static IWebDriver getDriverforWeb(String runModeType){
         return WEB.get(runModeType).get();
    }


}
