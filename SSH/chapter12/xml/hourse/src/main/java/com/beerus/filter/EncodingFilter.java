package com.beerus.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 字符编码过滤器
 * @Date 2019/3/28
 **/
public class EncodingFilter implements Filter {
    private String encoding = null; //编码格式

    public void init(FilterConfig filterConfig) throws ServletException {
        if (null == encoding) {
            //读取过滤器初始化参数
            encoding = filterConfig.getInitParameter("encoding");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置对应的编码格式
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        //servletResponse.setContentType("text/html;charset=" + encoding);
        //执行请求
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        //销毁编码对象
        encoding = null;
    }
}
