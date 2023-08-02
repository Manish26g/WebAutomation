package com.lambdaEcommerce.Test.Register;

import com.lambdaEcommerce.Test.WebBase;
import com.lambdaEcommerce.pages.ecommerce.HomePage;
import com.lambdaEcommerce.pages.ecommerce.HomePage01;
import com.lambdaEcommerce.pages.ecommerce.RegisterPage;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;
import org.testng.annotations.*;
import com.lambdaEcommerce.pages.base.WebUI;

public class RegisterTest extends WebBase {


    /*public void demotest(){

        //FrameworkConfig01 config01= ConfigCache.getOrCreate(FrameworkConfig01.class);
        //System.out.println(FrameworkConfigFactory.getConfig().browser());
    }*/

    /*@Test
    public void testRegisteration(){
        new HomePage()
                .getTopMenuComponent()
                .clickRegister(MenuType.MYACCOUNT,SubMenuType.REGISTER)
                .registerIntoApplication("Manish","Kumar","uiFramework@dispostable.com",
                        "+919999112233","Testing@1234","Testing@1234");

    }*/

    @Test
    public void testRegisteration01(){
        new HomePage01()
                .clickRegister(MenuType.MYACCOUNT,SubMenuType.REGISTER)
                .registerIntoApplication("Manish","Kumar","ash26rana@gmail.com",
                        "+919999112233","Test1234","Test1234");


    }
}
