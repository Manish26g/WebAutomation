package com.lambdaEcommerce.utils.LoginPoiji;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelCellRange;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PoijiData {

    /*@ExcelCell(0)
    public String testname;
    @ExcelCellName("torun")
    public String torun;
    @ExcelCellName("email")
    public String email;
    @ExcelCellName("password")
    public String password;*/

    @ExcelCell(0)
    public String testname;
    @ExcelCellName("torun")
    public String torun;

    @ExcelCellName("email")
    public String email;
    @ExcelCellName("password")
    public String password;

    /*@ExcelCellRange
    public LoginInfo getLoginInfo;


    @ToString
    public static class LoginInfo{

        @ExcelCellName("email")
        public String Email;

        @ExcelCellName("password")
        public String Password;
    }*/

}
