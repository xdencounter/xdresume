<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>登录页面Admin后台管理系统模板</title>
	<link rel="stylesheet" href="<%=basePath %>resource/admin/css/style.default.css" type="text/css" />
  </head>
   <script type="text/javascript">
	function clear_msg(id){   		
		//alert(11);
		//var  $m=jQuery.noConflict();
        		$("#"+id).text("");
    }
 
	
 
	function c(){
		$("#msg").text("");
	}
	
	function check1(){
	
        		//var reg=/^\w{6,12}$/;
        	  	//var reg2=/[\u4e00-\u9fa5A-Za-z0-9]{4,12}/;
        		var loginword=$("#usercode").val();
        		    		
        		if(loginword==""){
        			$("#msg").text("用户名或者密码不能为空");
        			return;        			      			
        		}
        		var password=$("#password").val();
        		if(password==""){
        			$("#msg").text("用户名或者密码不能为空"); 
        			return;
        		}
        	
        	    c();
        	    
        	    
        		$.ajax({ url:"<%=basePath %>login/checkLogin",
        		         cache:false,
        		         type:'POST',
        				 data:{"name":loginword,"pwd":password},
        				 dataType:"json",
        				 success:function(x){
        				    
        					//0 失败
        					if(x.retcode=="0"){
        						$("#msg").text("用户名或密码不正确");        						
        					}
        					// 1 成功
        					if(x.retcode=="1"){
        						window.location.href="<%=basePath %>index";     					
        				    } 
        				 }
        			});    
        			return;   		
        	}

    $("#usercode").keydown(function(e){
		var key=e.which;
		if(key==13){
			$("#password")[0].focus();
		}
    });
     $("#password").keydown(function(e){
		var key=e.which;
		if(key==13){
				check1();
		}
    }); 
</script> 
  <body>
   <body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo">Ama.<span>Admin</span></h1>
				<span class="slogan">后台管理系统</span>
            </div><!--logo-->
            
            <br clear="all" /><br />
            
            <div class="nousername">
				<div class="loginmsg">密码不正确.</div>
            </div><!--nousername-->
            
            <div class="nopassword">
				<div class="loginmsg">密码不正确.</div>
                <div class="loginf">
                    <div class="thumb"><img alt="" src="<%=basePath %>resource/admin/images/thumbs/avatar1.png" /></div>
                    <div class="userlogged">
                        <h4></h4>
                        <a href="index.html">Not <span></span>?</a> 
                    </div>
                </div><!--loginf-->
            </div><!--nopassword-->
            
            <form id="login" action="adminlogin" method="post">
            	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="username" id="username" />
                    </div>
                </div>
                
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" />
                    </div>
                </div>
                
                <button>登录</button>
                
                <div class="keep"><input type="checkbox" /> 记住密码</div>
            
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->
  </body>
</html>
