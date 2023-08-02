package com.lambdaEcommerce.driver.factories.web.remote;

import com.lambdaEcommerce.driver.manager.web.remote.selenium.SeleniumGridChromeManager01;
import com.lambdaEcommerce.driver.manager.web.remote.selenium.SeleniumGridFirefoxManager01;
import com.lambdaEcommerce.enums.BrowserType;
import org.openqa.selenium.WebDriver;


public final class SeleniumGridFactory01 {

  private SeleniumGridFactory01() {
  }

  public static WebDriver getDriver(BrowserType browserType){
    return browserType == BrowserType.CHROME?
            SeleniumGridChromeManager01.getDriver(): SeleniumGridFirefoxManager01.getDriver();
  }




}
