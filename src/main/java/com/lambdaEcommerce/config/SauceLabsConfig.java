package com.lambdaEcommerce.config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/config/sauce-labs.properties"
})

public interface SauceLabsConfig extends Config {

    @Key("username")
    String userName();

    String key();

    @DefaultValue("saucelabsendpoint")
    String sauceLabsURL();

}
