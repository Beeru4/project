package com.beerus.utils;

/**
 * @Author Beerus
 * @Description 自定义结果类
 * @Date 2019/4/23
 **/
public class Result {
    private int code;//错误编码
    private String msg;//错误信息

    /**
     * 初始化结果状态
     *
     * @param code
     * @param msg
     */
    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
