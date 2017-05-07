<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404-无法找到页面</title>
</head>
<body>
	404<br />
	无法找到页面！<br />
	${msg}<br />
  <a href="javascript:history.go(-1);">返回上一页</a> &nbsp;&nbsp;<a href="<%=basePath%>">返回首页</a>
</body>
</html>