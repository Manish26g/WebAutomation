package com.lambdaEcommerce.config;

import com.lambdaEcommerce.enums.RunModeType;
import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
      "system:properties",
      "system:env",
      "file:${user.dir}/src/test/resources/config/config.properties",
      "file:${user.dir}/src/test/resources/config/staging-config.properties",
      "file:${user.dir}/src/test/resources/config/dev-config.properties"
})

public interface FrameworkConfig extends Config {

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.webUrl")
    String webUrl();

    @DefaultValue("CHROME")
    String browser();

    @Key("runModeBrowser")
    String runModeLocal();

    @Key("runmode")
    @DefaultValue("selenoid")
    String runmode();

    @Key("sendresulttoelk")
    @DefaultValue("false")
    Boolean sendresulttoelk();

    @Key("selenoidURL")
    @DefaultValue("http://localhost:4444/wd/hub")
    String selenoidURL();

    @Key("seleniumgridurl")
    @DefaultValue("http://localhost:4444/wd/hub")
    String seleniumgridurl();

    @Key("elasticurl")
    @DefaultValue("http://localhost:9200/regression/results")
    String elasticurl();




}
