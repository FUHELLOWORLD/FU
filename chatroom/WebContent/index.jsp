<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body align = "center">
    <h1>欢迎光临聊天室系统</h1>
    <form action="login">
       用户名：<input type="text" name="userid">
       性别：<input type="radio" name="sex" value="帅哥" checked>帅哥
       <input type="radio" name="sex" value="美女">美女<br />
       <br />
       <input type="submit" value="进入"><input type="reset" value="重写">
    </form>
  </body>
</html>
