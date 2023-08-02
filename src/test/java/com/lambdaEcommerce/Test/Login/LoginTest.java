package com.lambdaEcommerce.Test.Login;



import com.lambdaEcommerce.Test.WebBase;

import com.lambdaEcommerce.annotations.FrameworkAnnotation;
import com.lambdaEcommerce.driver01.Manager.driverManager;

import com.lambdaEcommerce.enums.AuthorType;
import com.lambdaEcommerce.enums.CategoryType;
import com.lambdaEcommerce.pages.ecommerce.HomePage01;
import com.lambdaEcommerce.pages.ecommerce.LoginPage;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lambdaEcommerce.Test.listeners.AllureListener;



@Listeners({AllureListener.class})
@Epic("Regression Test")
@Feature("LoginTest")
public class LoginTest extends WebBase {
    SoftAssert Assert = new SoftAssert();

    @Test(description = "Testing Login Functionality with First User")
    @Step("1.Launch URL, 2.MouseOver on My Account and Click on Login, 3.Enter Email and Password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login into the Lambda Ecommerce Application")
    @Story("Story: User Login")

   // @Test
    @FrameworkAnnotation(author = {AuthorType.MANISH},category = {CategoryType.SMOKE})
    public void testLogin() {
        new HomePage01()
                .clickLogin(MenuType.MYACCOUNT, SubMenuType.LOGIN);
        new LoginPage()
                .loginToApplication("ash26rana", "Test1234");

        String actualURL = driverManager.getDriver().getCurrentUrl();
        System.out.println("After login URL is " + "---->" + actualURL);
        String expectedURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/account";

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertAll();
    }

}
