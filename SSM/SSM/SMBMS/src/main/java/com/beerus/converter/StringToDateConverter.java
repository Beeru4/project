package com.beerus.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Beerus
 * @Description 字符串转日期
 * @Date 2019-05-10
 **/
public class StringToDateConverter implements Converter<java.lang.String, java.util.Date> {
    /**
     * 要转的字符格式
     */
    private String[] patterns;

    /**
     * 通过构造注入字符串格式
     *
     * @param patterns
     */
    public StringToDateConverter(String[] patterns) {
        this.patterns = patterns;
    }

    /**
     * 转换日期
     *
     * @param s 要转换的字符串
     * @return 转后的日期
     */
    public Date convert(String s) {
        //循环转换日期
        for (String pattern : patterns) {
            try {
                //循环转换
                return new SimpleDateFormat(pattern).parse(s);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }
}
