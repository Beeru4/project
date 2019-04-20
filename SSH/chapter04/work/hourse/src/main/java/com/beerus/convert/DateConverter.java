package com.beerus.convert;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 日期格式化工具类
 * @Date 2019/4/8
 **/
public class DateConverter extends StrutsTypeConverter {
    //转换格式
    private final String[] formats = {"yyyy-MM-dd", "yyyy.MM.dd", "yyyy/MM/dd", "yyyy_MM_dd"};

    /**
     * @param map     OGNL上下文对象
     * @param strings 传入要格式化的参数
     * @param aClass  要转换的目标类型
     * @return 返回转换后的日期
     */
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        String dataStg = strings[0];
        for (String format : formats) {
            try {
                //返回转换后的格式
                return new SimpleDateFormat(format).parse(dataStg);
            } catch (ParseException e) {
                continue;
            }
        }
        //转换后没有匹配的格式出现异常
        throw new TypeConversionException();
    }

    /**
     * @param map OGNL上下文对象
     * @param o   要转换的对象
     * @return 日期转换后的字符串
     */
    public String convertToString(Map map, Object o) {
        //返回转换后的字符串
        return new SimpleDateFormat("yyyy-MM-dd").format((Date) o);
    }
}
