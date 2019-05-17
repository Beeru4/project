package com.beerus.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 字符编码过滤器
 * @Date 2019-05-16
 **/
public class EncodingFilter implements Filter {
    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行了init-------------------------------------------------------------------");
        //获取编码格式
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行了doFilter-------------------------------------------------------------------");
        //设置编码格式
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        response.setContentType("text/html;charset=" + this.encoding);
        filterChain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("执行了destory-------------------------------------------------------------------");
    }
}
