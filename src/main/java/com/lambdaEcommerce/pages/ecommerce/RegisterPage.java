package com.lambdaEcommerce.pages.ecommerce;

import com.lambdaEcommerce.driver.DriverManager;
import com.lambdaEcommerce.enums.WaitStrategy;
import com.lambdaEcommerce.utils.Decode.decodeUtils;
import org.openqa.selenium.By;
import static com.lambdaEcommerce.pages.base.WebUI.*;
import com.lambdaEcommerce.utils.Decode.decodeUtils.*;

public class RegisterPage {

    //public RegisterPage(){};

    private static final By FIRST_NAME = By.xpath("//input[@id='input-firstname']");
    private static final By LAST_NAME = By.xpath("//input[@id='input-lastname']");
    private static final By EMAIL = By.xpath("//input[@id='input-email']");
    private static final By TELEPHONE = By.xpath("//input[@id='input-telephone']");
    private static final By PASSWORD = By.xpath("//input[@id='input-password']");
    private static final By PASSWORD_CONFIRM = By.xpath("//input[@id='input-confirm']");
    private static final By PRIVACY_POLICY_AGREE = By.xpath("//input[@id='input-agree']");
    private static final By CONTINUE = By.xpath("//input[@type='submit']");
    private static final By ACCOUNT_CONFIRMATION_MESSAGE= By.xpath("//div[@id='content']/h1");



    private RegisterPage enterFirstName(String firstname){
        sendKeys(FIRST_NAME,firstname, WaitStrategy.PRESENCE,"Firstname");
        //setText(FIRST_NAME,firstname);
        return this;
    }

    private RegisterPage enterLastName(String lastname){
        setText(LAST_NAME,lastname);
        return this;
    }

    private RegisterPage enterEmail(String email){
        setText(EMAIL,email);
        return this;
    }

    private RegisterPage enterTelephone(String telephone){
        setText(TELEPHONE,telephone);
        return this;
    }

    private RegisterPage enterPassword(String password){
        //setText(PASSWORD,password);
        sendKeys(PASSWORD,decodeUtils.getDecodedString(password),WaitStrategy.PRESENCE,"Password");
        return this;
    }

    private RegisterPage enterPassword_confirm(String password_confirm){
        sendKeys(PASSWORD_CONFIRM,decodeUtils.getDecodedString(password_confirm),WaitStrategy.PRESENCE, "Password_confirm");
        return this;
    }

    private RegisterPage clickPrivacyPolicy(){
        //clickElement(PRIVACY_POLICY_AGREE);
        //click(PRIVACY_POLICY_AGREE,WaitStrategy.VISIBLE,"PRIVACY_POLICY_AGREE");
        ClickOnUsingJavaScript(PRIVACY_POLICY_AGREE);

        return this;
    }

    private HomePage clickContinueButton(){
        clickElement(CONTINUE);
        verifyElementText(ACCOUNT_CONFIRMATION_MESSAGE,"Your Account Has Been Created!");
        return new HomePage();
    }


    public HomePage registerIntoApplication(String firstname, String lastname, String email, String telephone,
                                                String password, String password_confirm){
        return enterFirstName(firstname)
                .enterLastName(lastname)
                .enterEmail(email)
                .enterTelephone(telephone)
                .enterPassword(password)
                .enterPassword_confirm(password_confirm)
                .clickPrivacyPolicy()
                .clickContinueButton();
    }













}
