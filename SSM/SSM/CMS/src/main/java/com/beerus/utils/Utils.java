package com.beerus.utils;

/**
 * @Author Beerus
 * @Description 工具类
 * @Date 2019-05-15
 **/
public class Utils {


    private Utils() {
    }

    /**
     * 判断字符串是否为""或者NULL
     *
     * @return
     */
    public static boolean isNotEmptyAndNull(String stg) {
        boolean result = !(null == stg || "".equals(stg));
        return result;
    }

    /**
     * 判断字符串是否为NULL
     *
     * @return
     */
    public static boolean isNotNull(Object params) {
        boolean result = null != params;
        return result;
    }

    /**
     * 判断字符串是否为NULL
     *
     * @return
     */
    public static boolean isNull(Object params) {
        boolean result = null == params;
        return result;
    }

}
