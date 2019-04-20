package com.beerus.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数工具类 用来绑定多个Hql参数
 */
public class Params {
    //替换的参数
    private static Map<String, Object> param = new HashMap<String, Object>();

    /**
     * @param key   添加的键值
     * @param vlaue 添加的value值
     */
    public static void add(String key, Object vlaue) {
        param.put(key, vlaue);
    }

    /**
     * @return 返回当前参数集合
     */
    public static Map<String, Object> getHashMap() {
        return param;
    }
}
