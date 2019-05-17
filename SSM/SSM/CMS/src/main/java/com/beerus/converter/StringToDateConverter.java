package com.beerus.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Beerus
 * @Description 自定义转换器:字符串转日期
 * @Date 2019-05-15
 **/
public class StringToDateConverter implements Converter<java.lang.String, java.util.Date> {

    private String[] patters;

    /**
     * 通过Spring构造注入转换格式
     */
    public StringToDateConverter(String[] patters) {
        this.patters = patters;
    }

    /**
     * 自定义转换日期
     *
     * @param s
     * @return
     */
    public Date convert(String s) {
        for (String patter : patters) {
            try {
                return new SimpleDateFormat(patter).parse(s);
            } catch (ParseException e) {
                //出现异常 继续转换
                continue;
            }
        }
        return null;
    }
}
