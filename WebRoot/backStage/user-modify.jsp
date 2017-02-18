<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/etc" prefix="etc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE >
<html>
  <head>
   <base href="<%=basePath%>">
     <meta charset="utf-8" />
    <title>MH心理健康网后台管理</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="resources/backStage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/backStage/css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    
    <link href="resources/backStage/css/font-awesome.css" rel="stylesheet" />
    
    <link href="resources/backStage/css/adminia.css" rel="stylesheet" /> 
    <link href="resources/backStage/css/adminia-responsive.css" rel="stylesheet" /> 
    
    <link href="resources/backStage/css/pages/dashboard.css" rel="stylesheet" /> 

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  </head>
  
  <body>
    <div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="user-list">MH心理健康网后台管理</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					<li>
						<a href="#"><span class="badge badge-warning">7</span></a>
					</li>
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown">
						
						<a data-toggle="dropdown" class="dropdown-toggle " href="#">
							${sessionScope.userName }  <b class="caret"></b>							
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<a href="account?userNo=${sessionScope.userId }"><i class="icon-user"></i> 账户设置  </a>
							</li>
							
							<li>
								<a href="backStage/change_password.jsp"><i class="icon-lock"></i> 修改密码</a>
							</li>
							<li class="divider"></li>
							
							<li>
								<a href="loginout?path=1"><i class="icon-off"></i> 注销</a>
							</li>
						</ul>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->




<div id="content">
	
	<div class="container">
		
		<div class="row">
			
			<div class="span3">
				
				<div class="account-container">
				
					<div class="account-avatar">
						<img src="resources/backStage/img/headshot.png" alt="" class="thumbnail" />
					</div> <!-- /account-avatar -->
				
					<div class="account-details">
					
						<span class="account-name">${sessionScope.userName }</span>
						
						<span class="account-role">管理员</span>
						
						<span class="account-actions">
							<a href="javascript:;">简介</a> |
							
							<a href="javascript:;">编辑设置</a>
						</span>
					
					</div> <!-- /account-details -->
				
				</div> <!-- /account-container -->
				
				<hr />
				
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					
					<li class="active">
						<a href="user-list">
							<i class="icon-home"></i>
							用户信息管理		
						</a>
					</li>
					
					<li>
						<a href="book-list">
							<i class="icon-pushpin"></i>
							书籍信息管理
						</a>
					</li>
					
					<li>
						<a href="article-list">
							<i class="icon-pushpin"></i>
							文章信息管理
						</a>
					</li>
					
					<li>
						<a href="account?userId=${sessionScope.userId }">
							<i class="icon-user"></i>
							账户信息管理							
						</a>
					</li>
					<li>
						<a href="exam-list">
							<i class="icon-pushpin"></i>
							题库管理
						</a>
					</li>
					<li>
						<a href="loginout?path=1">
							<i class="icon-lock"></i>
							切换登录
						</a>
					</li>
					
				</ul>	
				
				<hr />
				
				<br />
		
			</div> <!-- /span3 -->
			
			
			
			<div class="span9">
				
				<h1 class="page-title">
					<i class="icon-th-large"></i>
					用户信息管理					
				</h1>

				
						<div class="widget">
							
							<div class="widget-header">
								<h3>用户操作</h3>
							</div> <!-- /widget-header -->
									
							<div class="widget-content">
								
								
								

						<ul class="nav nav-tabs">
						  <li class="active">
						    <a href="#1" data-toggle="tab">修改用户信息</a>
						</ul>

						
							<div class="tab-content" >
								<div class="tab-pane active" id="1">
								<form method="post" action="user-modify2?userNo=${vo.userNo }" id="edit-profile" class="form-horizontal" >
									<fieldset>
										
										<div class="control-group">											
											<label class="control-label" for="userName">用户名</label>
											<div class="controls">
												<input type="text" class="input-medium" name="userName" value="${vo.userName }" readonly/>
												<p class="help-block">您的用户民不能再被更改.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="userPwd">密码</label>
											<div class="controls">
												<input type="password" class="input-medium " name="userPwd" value="${vo.userPwd }" readonly />
												<p class="help-block">您的密码不能再被更改.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="userRealName">真实姓名</label>
											<div class="controls">
												<input type="text" class="input-medium" name="userRealName" value="${vo.userRealName }" />
												
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">
												<label class="control-label" for="userSex">性别</label>
												<div class="controls">
												<c:if test="${vo.userSex }">
													<label class="radio">
														<input type="radio" name="userSex" value="true" checked="checked" id="userSex" />
														男
													</label>
													<label class="radio">
														<input type="radio" name="userSex" value="false" id="userSex"/>
														女
													</label>
												</c:if>
												<c:if test="${!vo.userSex }">
													<label class="radio">
														<input type="radio" name="userSex" value="true"  id="userSex" />
														男
													</label>
													<label class="radio">
														<input type="radio" name="userSex" value="false" checked="checked" id="userSex"/>
														女
													</label>
												</c:if>
												</div>
											</div>
										
										<div class="control-group">											
											<label class="control-label" for="userAge">年龄</label>
											<div class="controls">
												<input type="text" class="input-medium" name="userAge" value="${vo.userAge }" />
												
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->

										<div class="control-group">											
											<label class="control-label" for="userTel">电话号码</label>
											<div class="controls">
												<input type="text" class="input-medium" name="userTel" value="${vo.userTel }" />
												<p class="help-block">电话号码不能为空.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="userRole">角色</label>
											<div class="controls">
												<c:if test="${vo.userRole }">
												<input type="text" class="input-medium disabled" name="userRole" placeholder="管理员" value="" readonly />
												</c:if>
												<c:if test="${!vo.userRole }">
												<input type="text" class="input-medium disabled" name="userRole" placeholder="普通用户" value="" readonly />
												</c:if>
												<p class="help-block">您的角色权限不能再被更改.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
											
											<br />
										
											
										<div class="form-actions">
											<button type="submit" class="btn btn-primary">修改</button> 
											<button class="btn"><a href="user-list.action">返回</a></button>
										</div> <!-- /form-actions -->
									</fieldset>
								</form>
								</div>
								
							</div>
						 	  
						</div>		
								
							</div> <!-- /widget-content -->
							
						</div> <!-- /widget -->
						
					

			</div>
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /content -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/backStage/js/jquery-1.7.2.min.js"></script>


<script src="resources/backStage/js/bootstrap.js"></script>
  </body>
</html>
