<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-05-13
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/tags.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/WEB-INF/views/common/meta.jsp" %>
    <title>系统登录</title>
    <script src="${webRoot}/resources/plug-in/jQuery/jquery-2.2.4.js"></script>
    <script src="${webRoot}/resources/plug-in/jQuery/jquery.cookie.js"></script>
    <link href="${webRoot}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        * {font-family: "Verdana", "Tahoma", "Lucida Grande", "Microsoft YaHei", "Hiragino Sans GB", sans-serif;}
        body {
            background: url(${webRoot}/resources/img/images/loginbg_01.jpg) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
        a:link {color: #285e8e;}
        .main_box {
            position: absolute; top:50%; left:50%; margin-top:-260px; margin-left: -300px; padding: 30px; width:600px; height:460px;
            background: #FAFAFA; background: rgba(255,255,255,0.5); border: 1px #DDD solid;
            border-radius: 5px;
            -webkit-box-shadow: 1px 5px 8px #888888; -moz-box-shadow: 1px 5px 8px #888888; box-shadow: 1px 5px 8px #888888;
        }
        .main_box .setting {position: absolute; top: 5px; right: 10px; width: 10px; height: 10px;}
        .main_box .setting a {color: #FF6600;}
        .main_box .setting a:hover {color: #555;}
        .login_logo {margin-bottom: 20px; height: 45px; text-align: center;}
        .login_logo img {height: 45px;}
        .login_msg {text-align: center; font-size: 16px;}
        .login_form {padding-top: 20px; font-size: 16px;}
        .login_box .form-control {display: inline-block; *display: inline; zoom: 1; width: auto; font-size: 18px;}
        .login_box .form-control.x319 {width: 319px;}
        .login_box .form-control.x164 {width: 164px;}
        .login_box .form-group {margin-bottom: 20px;}
        .login_box .form-group label.t {width: 120px; text-align: right; cursor: pointer;}
        .login_box .form-group.space {padding-top: 15px; border-top: 1px #FFF dotted;}
        .login_box .form-group img {margin-top: 1px; height: 32px; vertical-align: top;}
        .login_box .m {cursor: pointer;}
        .bottom {text-align: center; font-size: 12px;}
    </style>
    <script type="text/javascript">
        var COOKIE_NAME = 'sys__username';
        $(function() {
            choose_bg();
            //changeCode();
            if ($.cookie(COOKIE_NAME)){
                $("#j_username").val($.cookie(COOKIE_NAME));
                $("#j_password").focus();
                $("#j_remember").attr('checked', true);
            } else {
                $("#j_username").focus();
            }
            /*$("#captcha_img").click(function(){
             changeCode();
             });*/
            $("#login_form").submit(function(){
                var issubmit = true;
                var i_index  = 0;
                $(this).find('.in').each(function(i){
                    if ($.trim($(this).val()).length == 0) {
                        $(this).css('border', '1px #ff0000 solid');
                        issubmit = false;
                        if (i_index == 0)
                            i_index  = i;
                    }
                });
                if (!issubmit) {
                    $(this).find('.in').eq(i_index).focus();
                    return false;
                }
                var $remember = $("#j_remember");
                if ($remember.attr('checked')) {
                    $.cookie(COOKIE_NAME, $("#j_username").val(), { path: '/', expires: 15 });
                } else {
                    $.cookie(COOKIE_NAME, null, { path: '/' });  //删除cookie
                }
                $("#login_ok").attr("disabled", true).val('登陆中..');
            });
        });
        function genTimestamp(){
            var time = new Date();
            return time.getTime();
        }
        function changeCode(){
            //$("#captcha_img").attr("src", "/captcha.jpeg?t="+genTimestamp());
        }
        function choose_bg() {

            var bg = Math.floor(Math.random() * 9 + 1);
            $('body').css('background-image', 'url(${webRoot}/resources/img/images/loginbg_0'+ bg +'.jpg)');
        }
    </script>
</head>
<body>
<div class="main_box">
    <div class="setting"><a href="javascript:void(0);" title="更换背景"></a></div>
    <div class="login_box">
        <div class="login_logo">
            <img src="resources/img/images/logo.jpg">
        </div>
        <!--
		<c:if test="${!empty message}">
			<div class="login_msg">
	      		<font color="red">${message }</font>
	    	</div>
	    </c:if>
        -->
        <div class="login_form">

            <form action="${webRoot}/adminLogin.do" id="login_form" method="post">

                <div class="form-group">
                    <label for="j_username" class="t">用户名：</label> <input id="j_username" name="userName"
                                                                          type="text" class="form-control x319 in"
                                                                          autocomplete="off" value>
                </div>
                <div class="form-group">
                    <label for="j_password" class="t">密　码：</label> <input id="j_password" name="password" value
                                                                          type="password" class="form-control x319 in">
                </div>
                <div class="form-group">
                    <label for="j_captcha" class="t">验证码：</label> <input id="j_captcha" name="code" type="text" class="form-control x164 in">
                    <img id="imgObj"  alt="" title="点击更换" src="verifyCode.do" onclick="javascript:this.src='verifyCode.do?rnd='+ Math.random();"/>
                </div>
                <div class="form-group">
                    <label class="t"></label>
                    <label for="j_remember" class="m"><input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
                </div>
                <div class="form-group space">
                    <label class="t"></label>
                    <input type="submit" id="login_ok" value="&nbsp;登&nbsp;录&nbsp;" class="btn btn-primary btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
                </div>
            </form>
        </div>
    </div>
    <div class="bottom">Copyright &copy; 2017 - 2020 <a href="#">系统登陆</a></div>
</div>
</body>
</html>
