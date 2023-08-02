package com.lambdaEcommerce.Test.LoginUsingZeroCell;

import com.lambdaEcommerce.Test.WebBase;
import com.lambdaEcommerce.pages.ecommerce.HomePage01;
import com.lambdaEcommerce.pages.ecommerce.LoginPage;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;
import com.lambdaEcommerce.testdata.TestData;
import com.lambdaEcommerce.utils.zerocell.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class zerocellLoginTest extends WebBase {

    @Test(dataProvider = "getTestData")
    public void Login(TestData data){
        new HomePage01()
                .clickLogin(MenuType.MYACCOUNT, SubMenuType.LOGIN);

        new LoginPage()
                .loginToApplication(data.getEmail(), data.getPassword());

    }

    @DataProvider
    public Object[] getTestData(){
        return ExcelReader.getTestdatas()
                .stream()
                .filter(e->e.getTestName().equalsIgnoreCase("loginWithFirstValidCredentails"))
                .toArray();


    }

}
