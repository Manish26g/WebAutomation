package com.lambdaEcommerce.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

public class PhoneNumberConverter implements Converter<String> {
    @Override
    public String convert(String value, String columnName, int row) {
        return value.startsWith("+91")?value:"+91"+value;
    }
}
