<%@ page language="java" pageEncoding="UTF-8"%>
<%response.setHeader("Pragma","No-cache"); %>
<%response.setHeader("Cache-Control","no-cache"); %>
<%response.setHeader("Expires","0");%>
<html>
<head></head>  
<body>
	<jsp:forward page="/page/login_struts2.jsp"></jsp:forward>
	<%--<jsp:forward page="/findAllUserServlet"></jsp:forward>--%>
</body>
</html>