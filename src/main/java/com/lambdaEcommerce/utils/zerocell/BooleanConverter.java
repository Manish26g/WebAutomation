package com.lambdaEcommerce.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

public class BooleanConverter implements Converter<Boolean> {
    @Override
    public Boolean convert(String value, String columnName, int row) {
        return value.equalsIgnoreCase("true");
    }
}
