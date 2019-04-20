package com.beerus.utils;


import java.util.Set;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/10
 **/
public class Result<T> {
    private int code;
    private String message;
    private Set<T> saleOrderLines;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Set<T> getSaleOrderLines() {
        return saleOrderLines;
    }

    public void setSaleOrderLines(Set<T> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
