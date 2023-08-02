package com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent;

public enum SubMenuType {

    REGISTER("Register"),
    LOGIN("Login");

    SubMenuType(String name){
        this.name= name;
    }

    private final String name;

    public String getName() {
        return name;
    }

}
