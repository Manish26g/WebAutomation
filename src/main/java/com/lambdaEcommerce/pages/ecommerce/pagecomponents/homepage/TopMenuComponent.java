package com.lambdaEcommerce.pages.ecommerce.pagecomponents.homepage;


import com.lambdaEcommerce.pages.ecommerce.RegisterPage;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;
import org.openqa.selenium.By;

import static com.lambdaEcommerce.pages.base.WebUI.*;

public class TopMenuComponent {

    //Dynamic Xpath
    private static final String MENU= "(//span[contains(text(),'%s')])";
    private static final String NAVBAR_MENU= "(//span[contains(text(),'%s')])[2]";
    private static final String NAVBAR_MENU_ITEM= "(//span[contains(text(),'%s')])";


    /*public TopMenuComponent clickMyAccount(MenuType menuType){
        String xpath= String.format(NAVBAR_MENU,menuType.getName());
        //MouseHoverAndClick01(By.xpath(xpath));
        return this;

    }*/


    public RegisterPage clickRegister(MenuType menuType,SubMenuType subMenuType){
        String account= String.format(NAVBAR_MENU,menuType.getName());
        String register= String.format(NAVBAR_MENU_ITEM,subMenuType.getName());
        //waitForElementVisible(By.xpath(register));
        MouseHoverAndClick(By.xpath(account),By.xpath(register));
               return new RegisterPage();

    }
}
