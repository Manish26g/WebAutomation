package com.lambdaEcommerce.driver.factories.web.remote;

import com.lambdaEcommerce.config.factory.FrameworkConfigFactory;
import com.lambdaEcommerce.driver.manager.web.remote.selenium.SeleniumGridChromeManager01;
import com.lambdaEcommerce.enums.BrowserRemoteModeType;
import com.lambdaEcommerce.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory01 {

    private RemoteDriverFactory01(){}

    /*public static WebDriver getDriver(){
        BrowserRemoteModeType browserRemoteModeType= FrameworkConfigFactory.getConfig01().browserRemoteMode();
        if(browserRemoteModeType == BrowserRemoteModeType.SELENIUM){

        }else if(browserRemoteModeType == BrowserRemoteModeType.SELENOID){

        }

        return null;
    }*/


    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType){
        if(browserRemoteModeType == BrowserRemoteModeType.SELENIUM){
            return SeleniumGridFactory01.getDriver(browserType);

        }else if(browserRemoteModeType == BrowserRemoteModeType.BROWSER_STACK){

        }else if(browserRemoteModeType == BrowserRemoteModeType.SELENOID){

        }
        return null;
    }



}
