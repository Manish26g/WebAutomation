package com.lambdaEcommerce.driver;

import com.lambdaEcommerce.enums.PlarformType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.lambdaEcommerce.enums.PlarformType.*;
import static java.lang.ThreadLocal.*;

public final class DriverManager01 {

    //web---->mobile
    //web---->mobile---->web
    //1.web driver 2. mobile driver
    //At a particular instance, context -->WEB,MOBILE

    private DriverManager01(){}

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL= new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL= new ThreadLocal<>();
    private static final ThreadLocal<PlarformType> CONTEXT = withInitial(()-> WEB);



    public static WebDriver getDriver(){
        return WEB_DRIVER_THREAD_LOCAL.get();

    }

   public static void setDriver(WebDriver driver){
       if(Objects.nonNull(driver)){
           WEB_DRIVER_THREAD_LOCAL.set(driver);
       }
   }

   public static void unload(){
        WEB_DRIVER_THREAD_LOCAL.remove();
   }





}
