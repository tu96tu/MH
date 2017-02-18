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
    <title>注册</title>
    <jsp:include page="/inc.jsp"></jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    
    <link href="resources/backStage/css/font-awesome.css" rel="stylesheet" />
    
    <link href="resources/backStage/css/adminia.css" rel="stylesheet" /> 
    <link href="resources/backStage/css/adminia-responsive.css" rel="stylesheet" /> 
    
<link href="resources/backStage/css/pages/login.css" rel="stylesheet" /> 
    
	<script type="text/javascript" src="resources/jqBootstrapValidation.js"></script>
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  </head>
  
  <body>



<div id="login-container">
	
	
	<div id="login-header" style="width:600px">
		
		<h3>注册</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix" style="width:600px">
	<div class="panel-body">
	<form method="post" action="register" class="form-horizontal">
				<fieldset>

					<div class="control-group">

						<!-- Text input-->
						<label class="control-label col-md-2">用户名</label>
						<div class="col-md-10">
							<input required="required"  name="userName" placeholder="请输入用户名 " class="form-control" type="text">
							<p class="help-block">只能输入5-20个以字母开头、可带数字、“_”、“.”的字串 </p>
						</div>
					</div>

					<div class="control-group">

						<!-- Text input-->
						<label class="control-label col-md-2">登陆密码</label>
						<div class="col-md-10">
							<input name="userPwd" placeholder="请输入登陆密码" class="form-control" type="password">
							<p class="help-block">密码为3-10位的字符组成</p>
						</div>
					</div>

					<div class="control-group">

						<!-- Search input-->
						<label class="control-label col-md-2">密码确认</label>
						<div class="col-md-10">
							<input name="userPwdConfirm" placeholder="请再次输入密码" class="form-control" type="password">
							<p class="help-block">请再次输入登陆密码</p>
						</div>

					</div>

					<div class="control-group">
						<div class="col-md-5 col-md-offset-2">
							<button type="submit" class="btn btn-success">注册</button>
							<a class="btn btn-primary" href="login.jsp">返回登陆</a>
						</div>
					</div>
					</fieldset>
					<div class="control-group" style="color: red">
						${error}
					</div>
			</form>
			</div>
		</div> <!-- /login-content -->
		
		
		<div id="login-extra">
			
			<p>我有账号 <a href="login.jsp">返回登录.</a></p>
			
		</div> <!-- /login-extra -->
	
</div> <!-- /login-wrapper -->
<script type="text/javascript">
(function($){
	$(function(){
		var form = $("form");
		form.submit(function(){
			if(form.find(".has-error").size()>0){
				alert(form.find(".has-error:first").find("label:first").text()+"输入不正确");
				form.find(".has-error:first").find(":input").focus();
				return false;
			}else{
				return true;
			}
			
		});
		
		form.find("[name='userName']").on("keyup",function(){
			var the = $(this);
			if(/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/.test(the.val())){
				the.parents(".control-group:first").removeClass("has-error").addClass("has-success");
			}else{
				the.parents(".control-group:first").addClass("has-error");
			}
		});
		
		
		form.find("[name='userPwd']").on("keyup",function(){
			var the = $(this);
			if(/^\w{3,10}$/.test(the.val())){
				the.parents(".control-group:first").removeClass("has-error").addClass("has-success");
			}else{
				the.parents(".control-group:first").addClass("has-error");
			}
		});
		
		
		form.find("[name='userPwdConfirm'],[name='stdPwd']").on("keyup",function(){
			var the = form.find("[name='userPwdConfirm']");
			if(the.val()==form.find("[name='userPwd']").val()){
				the.parents(".control-group:first").removeClass("has-error").addClass("has-success");
			}else{
				the.parents(".control-group:first").addClass("has-error");
			}
		});
		
	});
})(jQuery);
</script>
    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/backStage/js/jquery-1.7.2.min.js"></script>


<script src="resources/backStage/js/bootstrap.js"></script>
  </body>
</html>