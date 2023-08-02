package com.lambdaEcommerce.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

public class IntegerConverter implements Converter<Integer> {

    @Override
    public Integer convert(String value, String columnName, int row) {
        return value == null? 0: Integer.parseInt(value);
    }
}
