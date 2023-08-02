package com.lambdaEcommerce.driver.entity;

import com.lambdaEcommerce.enums.BrowserRemoteModeType;
import com.lambdaEcommerce.enums.BrowserType;
import com.lambdaEcommerce.enums.RunModeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DriverData {

    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
    private RunModeType runModeType;
}
