package com.lambdaEcommerce.pages.ecommerce;



import com.lambdaEcommerce.pages.ecommerce.pagecomponents.homepage.TopMenuComponent;
import org.openqa.selenium.By;
import static com.lambdaEcommerce.pages.base.WebUI.*;


public class HomePage {


    private TopMenuComponent topMenuComponent;

    public HomePage(){
        this.topMenuComponent= new TopMenuComponent();
    }

    public TopMenuComponent getTopMenuComponent() {
        return topMenuComponent;
    }













}
