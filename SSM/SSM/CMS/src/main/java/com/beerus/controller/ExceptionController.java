package com.beerus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Beerus
 * @Description 异常控制器
 * @Date 2019-05-15
 **/
@Controller
@RequestMapping(value = "/error")
public class ExceptionController {

    @RequestMapping(value = "/400.html")
    public String error400Page() {
        return "/error/400";
    }

    @RequestMapping(value = "/403.html")
    public String error403Page() {
        return "/error/page_403";
    }

    @RequestMapping(value = "/404.html")
    public String error404Page() {
        return "/error/page_404";
    }

    @RequestMapping(value = "/500.html")
    public String error500Page() {
        return "/error/page_500";
    }
}
