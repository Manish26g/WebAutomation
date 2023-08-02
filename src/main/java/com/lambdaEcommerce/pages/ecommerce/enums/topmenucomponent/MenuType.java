package com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent;

public enum MenuType {

    HOME("Home"),
    SPECIAL("Special"),
    BLOG("Blog"),
    MEGA_MENU("Mega Menu"),
    ADDONS("AddOns"),
    MYACCOUNT("My account");

    MenuType(String name){
        this.name= name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
