package com.lambdaEcommerce.config;

import com.lambdaEcommerce.config.converters.StringToURLConverter;
import org.aeonbits.owner.Config;

import java.net.URL;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/config/browser-stack.properties"
})
public interface BrowserStackConfig01 extends Config {

    @Key("username")
    String userName();

    String key();

    @DefaultValue("https://${username}:${key}@hub-cloud.browserstack.com/wd/hub")
    String browserStackURL();



}