package com.lambdaEcommerce.config.factory;

import com.lambdaEcommerce.config.BrowserStackConfig;
import com.lambdaEcommerce.config.BrowserStackConfig01;
import org.aeonbits.owner.ConfigCache;

public class BrowserStackConfigFactory {

    private BrowserStackConfigFactory(){}

    public static BrowserStackConfig getConfig(){
        return ConfigCache.getOrCreate(BrowserStackConfig.class);

    }

    public static BrowserStackConfig01 getConfig01(){
        return ConfigCache.getOrCreate(BrowserStackConfig01.class);

    }
}
