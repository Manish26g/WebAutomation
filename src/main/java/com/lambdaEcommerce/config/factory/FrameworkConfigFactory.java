package com.lambdaEcommerce.config.factory;

import com.lambdaEcommerce.config.FrameworkConfig;
import com.lambdaEcommerce.config.FrameworkConfig01;
import com.lambdaEcommerce.config.FrameworkConfig02;
import org.aeonbits.owner.ConfigCache;

public final class FrameworkConfigFactory {

    // To avoid external instantiation
    private FrameworkConfigFactory(){}

    //Singleton Pattern- getorCreate
    /*public static FrameworkConfig getConfig() {

        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }*/



    //Singleton Pattern- getorCreate
    public static FrameworkConfig01 getConfig01() {

        return ConfigCache.getOrCreate(FrameworkConfig01.class);
    }

    public static FrameworkConfig02 getConfig02() {

        return ConfigCache.getOrCreate(FrameworkConfig02.class);
    }
}
