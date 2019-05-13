package com.beerus.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Beerus
 * @Description 日期转换工具类
 * @Date 2019-05-09
 **/
public class StringToDateConvert implements Converter<java.lang.String, java.util.Date> {
    /**
     * 编码格式,通过Spring注入进来
     */
    private String[] patterns;

    public StringToDateConvert(String[] patterns) {
        this.patterns = patterns;
    }

    /**
     * 实现转换日期的方法
     *
     * @param s 要转换的字符串
     * @return 返回转换后的日期
     */
    public Date convert(String s) {
        //循环遍历对应的格式
        for (String pattern : patterns) {
            try {
                //转换日期
                return new SimpleDateFormat(pattern).parse(s);
            } catch (ParseException e) {
                //出现异常 继续转换
                continue;
            }
        }
        return null;

    }
}
