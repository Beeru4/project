<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (null == session.getAttribute("emp")) {
        response.sendRedirect("/login.jsp");
        return;
    }
%>