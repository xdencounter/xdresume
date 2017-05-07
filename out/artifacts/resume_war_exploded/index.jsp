<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-05-07
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%@ page  pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <script type="text/javascript">

    //平台、设备和操作系统
    var system = {
      win: false,
      mac: false,
      xll: false,
      ipad:false
    };
    //检测平台
    var p = navigator.platform;
    system.win = p.indexOf("Win") == 0;
    system.mac = p.indexOf("Mac") == 0;
    system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
    system.ipad = (navigator.userAgent.match(/iPad/i) != null)?true:false;
    //跳转语句，如果是手机访问就自动跳转到wap.baidu.com页面
    if (system.win || system.mac || system.xll||system.ipad) {
      window.location.href="<%=basePath %>index";
    } else {

      window.location.href="<%=basePath %>wap_index";
    }

  </script>
  </body>
</html>
