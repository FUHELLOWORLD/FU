<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	session.setMaxInactiveInterval(3*60);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
	<frameset rows = "*,20%">
		<frame name = "content" src = "content.jsp" />
		<frame name = "sendmod" taraget = "content" src = "sendmod.jsp" />
		<noframes>
			<body>
				<p>浏览器不支持框架</p>
			</body>
		</noframes>
	</frameset>
</html>