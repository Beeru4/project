package com.beerus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Beerus
 * @Description 状态码控制层
 * @Date 2019-05-13
 **/
@Controller
@RequestMapping("/error")
public class ExceptionCodeController {

    private static final String BASE_DIR_404 = "error/404";
    private static final String BASE_DIR_500 = "error/500";
    private static final String BASE_DIR_400 = "error/400";


    /**
     * 错误状态码路径
     */
    private static final String ERROR_PAGE = "error404";

    @RequestMapping(value = "404")
    public String errorPage404(HttpServletRequest request) {
        request.setAttribute("error", "抱歉,页面未找到!");
        return ERROR_PAGE;
    }

    @RequestMapping(value = "500")
    public String errorPage500(HttpServletRequest request) {
        request.setAttribute("error", "抱歉,服务器繁忙!");
        return ERROR_PAGE;
    }

    @RequestMapping(value = "400")
    public String errorPage400(HttpServletRequest request) {
        request.setAttribute("error", "抱歉,客户端异常400!");
        return ERROR_PAGE;
    }

    @RequestMapping(value = "405")
    public String errorPage405(HttpServletRequest request) {
        request.setAttribute("error", "抱歉,客户端异常405!");
        return ERROR_PAGE;
    }
}
