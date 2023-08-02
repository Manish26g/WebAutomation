package com.lambdaEcommerce.testdata;

import com.creditdatamw.zerocell.annotation.Column;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TestData {

    @Column(name = "testname", index = 0)
    public String TestName;
    @Column(name = "torun", index = 1)
    public String ToRun;
    @Column(name = "email", index = 2)
    public String Email;
    @Column(name = "password", index = 3)
    public String Password;


}
