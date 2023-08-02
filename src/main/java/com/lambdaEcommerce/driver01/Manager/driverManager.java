package com.lambdaEcommerce.driver01.Manager;

import org.openqa.selenium.WebDriver;

public final class driverManager {

    private driverManager(){}

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }

    public static void unload() {
        threadLocal.remove();
    }

}
