package com.lambdaEcommerce.Test.LoginParallel;

import com.lambdaEcommerce.Test.WebBase;

import com.lambdaEcommerce.pages.ecommerce.HomePage01;
import com.lambdaEcommerce.pages.ecommerce.LoginPage;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;

import org.testng.annotations.Test;

public class LoginTest extends WebBase {



    @Test

    public void testLogin(){
        new HomePage01()
                .clickLogin(MenuType.MYACCOUNT, SubMenuType.LOGIN);
        new LoginPage()
                .loginToApplication("ash26rana@gmail.com","Test1234");

    }


    @Test

    public void test_Login(){
        new HomePage01()
                .clickLogin(MenuType.MYACCOUNT, SubMenuType.LOGIN);
        new LoginPage()
                .loginToApplication("26kumarmani@gmail.com","Test12345");

    }



}
