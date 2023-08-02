package com.lambdaEcommerce.driver.entity;


import com.lambdaEcommerce.enums.BrowserRemoteModeType;
import com.lambdaEcommerce.enums.BrowserType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {
     private BrowserType driverType;

     public WebDriverData(String browser) {
     }
     private BrowserRemoteModeType browserRemoteModeType;



}
