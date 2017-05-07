<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>500-出现错误了</title>
</head>
<body>
	500<br />
	异常:<br />
	${msg}<br />
	详情<br />
	<%=exception.getCause().getMessage()%><br />
  <a href="javascript:history.go(-1);">返回上一页</a> &nbsp;&nbsp;<a href="<%=basePath%>">返回首页</a>
</body>
</html>