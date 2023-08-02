package com.lambdaEcommerce.utils.zerocell;


import com.creditdatamw.zerocell.Reader;
import com.lambdaEcommerce.testdata.TestData;
import java.io.File;
import java.util.List;

public final class ExcelReader {

    private ExcelReader(){}

    public static List<TestData> getTestdatas(){
        return testdatas;
    }

    public static List<TestData> testdatas=null;

    static{
        testdatas= Reader.of(TestData.class)
                .from(new File("src/test/resources/LoginInfo.xlsx"))
                .sheet("Sheet1")
                .skipHeaderRow(true)
                .list();

    }
}
