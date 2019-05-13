package com.beerus.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Beerus
 * @Description 测试JSON数据
 * @Date 2019-05-09
 **/
public class JSONController {

    /**
     * 测试返回日期
     *
     * @return
     */
    @RequestMapping(value = "/json", produces = {"application/json;charset=utf-8"})
    public String json() {
        return "";
    }
}
