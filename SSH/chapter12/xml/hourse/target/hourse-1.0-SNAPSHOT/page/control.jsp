<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
if(null == session.getAttribute("user"))
    response.sendRedirect("/page/login_struts2.jsp");
%>