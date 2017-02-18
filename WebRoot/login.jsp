<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="shortcut icon" href="favicon.ico">
	<link rel="icon" type="image/x-icon" href="favicon.ico" />
    <title>登录</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="resources/backStage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/backStage/css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    
    <link href="resources/backStage/css/font-awesome.css" rel="stylesheet" />
    
    <link href="resources/backStage/css/adminia.css" rel="stylesheet" /> 
    <link href="resources/backStage/css/adminia-responsive.css" rel="stylesheet" /> 
    
    <link href="resources/backStage/css/pages/login.css" rel="stylesheet" /> 
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  </head>
  
  <body>
   


<div id="login-container">
	
	
	<div id="login-header">
		
		<h3>登录</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix">
	
	<form action="login" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="userName">用户名</label>
						<div class="controls">
							<input type="text" class="" name="userName" value="${vo.userName }" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="userPwd">密码</label>
						<div class="controls">
							<input type="password" class="" name="userPwd" value="${vo.userPwd }"/>
						</div>
					</div>
					<div class="control-group" style="color: red">
						${message }
					</div>
				</fieldset>
				
				<div id="remember-me" class="pull-left">
					<input type="checkbox" name="remember" id="remember" />
					<label id="remember-label" for="remember">记住密码</label>
				</div>
				
				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">
						登录
					</button>
				</div>
			</form>
			
		</div> <!-- /login-content -->
		
		
		<div id="login-extra">
			
			<p>没有账号? <a href="register.jsp">注册.</a></p>
			
			<p>忘记密码? <a href="forgot_password.jsp">找回密码.</a></p>
			
		</div> <!-- /login-extra -->
	
</div> <!-- /login-wrapper -->

    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/backStage/js/jquery-1.7.2.min.js"></script>


<script src="resources/backStage/js/bootstrap.js"></script>
  </body>
</html>
