package com.lambdaEcommerce.config;

import com.lambdaEcommerce.config.converters.StringToBrowserTypeConverter;
import com.lambdaEcommerce.config.converters.StringToRemoteModeBrowserTypeConverter;
import com.lambdaEcommerce.config.converters.StringToRunModeBrowserTypeConverter;
import com.lambdaEcommerce.config.converters.StringToURLConverter;
import com.lambdaEcommerce.enums.BrowserRemoteModeType;
import com.lambdaEcommerce.enums.BrowserType;
import com.lambdaEcommerce.enums.RunModeType;
import org.aeonbits.owner.Config;

import java.net.URL;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
      "system:properties",
      "system:env",
      "file:${user.dir}/src/test/resources/config/config.properties",
      "file:${user.dir}/src/test/resources/config/staging-config.properties",
      "file:${user.dir}/src/test/resources/config/dev-config.properties"
})

public interface FrameworkConfig01 extends Config {

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.webUrl")
    String webUrl();

    @Key("WAIT_PAGE_LOADED")
    int WAIT_PAGE_LOADED();



    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("runModeBrowser")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeType browserRunMode();

    @Key("browserRemoteMode")
    @ConverterClass(StringToRemoteModeBrowserTypeConverter.class)
    BrowserRemoteModeType browserRemoteMode();

    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();




}
