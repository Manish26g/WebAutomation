package com.lambdaEcommerce.config.factory;

import com.lambdaEcommerce.config.SauceLabsConfig;
import org.aeonbits.owner.ConfigCache;

public class SauceLabsConfigFactory {

    private SauceLabsConfigFactory(){}

    public static SauceLabsConfig getConfig(){
        return ConfigCache.getOrCreate(SauceLabsConfig.class);
    }
}
