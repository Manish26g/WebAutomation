package com.lambdaEcommerce.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String> {
    @Override
    public String convert(String value, String columnName, int row) {
         Date now= new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return simpleDateFormat.format(now);
    }


}
