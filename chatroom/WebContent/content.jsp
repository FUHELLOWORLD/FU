<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="liao.mod" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int i = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href = "<%=basePath %>">
	<title>content</title>
	<meta http-equiv="refresh" content="2">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword,keyword2">
	<meta http-equiv="description" content="this is my page">
</head>
<body>
	<c:forEach items = "${allmod}" var = "Mod">
		${Mod.userid}在${Mod.time}说:<font color="green">${Mod.info}</font>
		<br />
		<br />
	</c:forEach>
</body>
</html>