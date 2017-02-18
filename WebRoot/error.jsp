<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Gato Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="resources/proscenium/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="resources/proscenium/css/style.css" rel='stylesheet' type='text/css' />	
	<script src="resources/proscenium/js/jquery.min.js"> </script>
	<!--webfonts-->
	 <link href='http://fonts.useso.com/css?family=Raleway:400,100,200,300,500,600,700|Cinzel+Decorative:400,700' rel='stylesheet' type='text/css'>
	<!--//webfonts-->

  </head>
  
  <body>
<!--error-->
	<div class="error">
		<div class="container">
			<div class="error-top">
				<h3>404<span>ERROR!</span></h3>
				<p>${message }</p>
				<div class="error-btn">
				<a class="read fourth" href="login.jsp">返回登录</a>
				</div>
			</div>
		</div>
	</div>
	<!--error-->


  </body>
</html>
