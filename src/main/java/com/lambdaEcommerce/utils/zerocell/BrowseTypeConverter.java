package com.lambdaEcommerce.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;
import com.lambdaEcommerce.enums.BrowserType;

public class BrowseTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(String value, String columnName, int row) {
        return BrowserType.valueOf(value.toUpperCase());
    }
}
