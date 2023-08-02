package com.lambdaEcommerce.pages.ecommerce;

import org.openqa.selenium.By;

import static com.lambdaEcommerce.pages.base.WebUI.*;

public class LoginPage {

    private static final By EMAIL_ADDRESS= By.xpath("//input[@id='input-email']");
    private static final By PASSWORD= By.xpath("//input[@id='input-password']");
    private static final By LOGIN_BUTTON= By.xpath("//input[@type='submit']");

    //Dynamic Xpath
    private static final By LOGIN_CONFIRMATION= By.xpath("//h2[contains(text(),'%s')]");


    private LoginPage enterEmail(String Email){
        setText(EMAIL_ADDRESS,Email);
        return this;
    }

    private LoginPage enterPassword(String Password){
        setText(PASSWORD,Password);
        return this;
    }

    private MyAccountPage clickLogin(){
        clickElement(LOGIN_BUTTON);
        //verifyElementText(LOGIN_CONFIRMATION,"My Account");
        return new MyAccountPage();
    }

    public MyAccountPage loginToApplication(String Email, String Password){
        return enterEmail(Email)
                .enterPassword(Password)
                .clickLogin();
    }
}
