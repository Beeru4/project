package com.beerus.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 字符编码过滤器
 * @Date 2019/4/18
 **/
public class EncodingFilter implements Filter {
    //字符编码
    private String encoding = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        if (null == encoding) {
            encoding = filterConfig.getInitParameter("encoding");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置编码格式
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html; charset="+encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        //销毁对象
        encoding = null;
    }
}
