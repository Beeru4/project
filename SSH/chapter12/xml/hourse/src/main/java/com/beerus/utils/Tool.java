package com.beerus.utils;

/**
 * @Author Beerus
 * @Description 工具类
 * @Date 2019/3/29
 **/
public class Tool {
    /**
     * 创建JSON格式字符串
     *
     * @param result 返回的结果
     * @return JSON字符串
     */
    public static String currentJSON(String result) {

        return "\"result\":\"" + result + "\"";
    }
    public static String currentScript(String msg,String location){
        return "<script>alert('"+msg+"');location.href='"+location+"';</script>";
    }
}
