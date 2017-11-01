package com.boa.common.util;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatter extends org.springframework.format.datetime.DateFormatter {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        try{
            if( ValidateUtils.isNumber(text) ){
                return new Date(Long.valueOf(text));
            }
        }catch (Exception e){

        }
        return getDateFormat(locale).parse(text);
    }
}
