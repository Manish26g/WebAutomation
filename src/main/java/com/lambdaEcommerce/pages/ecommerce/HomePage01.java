package com.lambdaEcommerce.pages.ecommerce;

import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;
import com.lambdaEcommerce.utils.dynamicselector.DynamicXpathUtils;
import org.openqa.selenium.By;

import static com.lambdaEcommerce.pages.base.WebUI.MouseHoverAndClick;

public class HomePage01 {
    //Dynamic Xpath
    private static final String MENU= "(//span[contains(text(),'%s')])";
    private static final String NAVBAR_MENU= "(//span[contains(text(),'%s')])[2]";
    private static final String NAVBAR_MENU_ITEM= "(//span[contains(text(),'%s')])";

    public RegisterPage clickRegister(MenuType menuType, SubMenuType subMenuType){
                MouseHoverAndClick(By.xpath(DynamicXpathUtils.getXpath(NAVBAR_MENU,menuType.getName())),
                By.xpath(DynamicXpathUtils.getXpath(NAVBAR_MENU_ITEM,subMenuType.getName())));
        return new RegisterPage();

    }

    public LoginPage clickLogin(MenuType menuType, SubMenuType subMenuType) {
        MouseHoverAndClick(By.xpath(DynamicXpathUtils.getXpath(NAVBAR_MENU, menuType.getName())),
                By.xpath(DynamicXpathUtils.getXpath(NAVBAR_MENU_ITEM, subMenuType.getName())));
        return new LoginPage();
    }




}
