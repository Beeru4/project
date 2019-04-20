package com.beerus.filter;



import com.beerus.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 会话延长机制过滤器
 * @Date 2019/3/28
 **/
public class OpenSessionViewFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //开启事务
        Transaction transaction = null;
        try {
            transaction = HibernateUtils.getSession().beginTransaction();
            //执行请求处理连
            filterChain.doFilter(servletRequest,servletResponse);
            //返回相应 提交事务
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            //出现异常回滚事务
            if(null != transaction)
                transaction.rollback();
        }
    }

    public void destroy() {

    }
}
