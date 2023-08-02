package com.lambdaEcommerce.Test.LoginUsingPoiji;


import com.lambdaEcommerce.Test.WebBase;
import com.lambdaEcommerce.pages.ecommerce.HomePage01;
import com.lambdaEcommerce.pages.ecommerce.LoginPage;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.MenuType;
import com.lambdaEcommerce.pages.ecommerce.enums.topmenucomponent.SubMenuType;
import com.lambdaEcommerce.utils.LoginPoiji.PoijiData;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;


public class PoijiLoginTest extends WebBase {


    @DataProvider(name="loginDataPoiji")
        public static Object[] getLoginInfo(){
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().headerCount(2).build();
            /*List<PoijiData> data =*/ return Poiji.fromExcel(new File("src/test/resources/LoginInfo.xlsx"),
                    PoijiData.class,options)
                            .stream().filter(e->e.getTestname().
                        equalsIgnoreCase("loginWithFirstValidCredentails")).toArray();

    }

        @Test(dataProvider = "loginDataPoiji")
        public void testLogin(PoijiData data){
            new HomePage01()
                    .clickLogin(MenuType.MYACCOUNT, SubMenuType.LOGIN);
            if(data.testname.equalsIgnoreCase("loginWithFirstValidCredentails")){
                new LoginPage()
                        .loginToApplication(data.getEmail(), data.getPassword());
            }


        }









}
