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
					
					<li>
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
					<li class="active">
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
					试卷信息管理					
				</h1>
				
				
				<div class="row">
					
					<div class="span9">
				
						<div class="widget">
							
							<div class="widget-header">
								<h3>试卷操作</h3>
							</div> <!-- /widget-header -->
									
							<div class="widget-content">
								
								
								
								<div class="tabbable">
						<ul class="nav nav-tabs">
						  <li class="active">
						  	<a href="#2" data-toggle="tab">添加新试题</a>
						  </li>
						</ul>
						
						<br />
						
							<div class="tab-content">	
								<div class="tab-pane active" id="2">
									<form method="post" action="question-add?examNo=${param.examNo } " id="edit-profile" class="form-horizontal" />
									<fieldset>
										
										<div class="control-group">											
											<label class="control-label" for="quTitle">试题题目</label>
											<div class="controls">
												<input type="text" class="input-medium" name="quTitle" value="" />
												<p class="help-block">请输入题目标题.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="quOption1">选项1</label>
											<div class="controls">
												<textarea class="form-control" name="quOption1" rows="3" ></textarea>
												<p class="help-block">请输入选项1.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
											
										<div class="control-group">											
											<label class="control-label" for="quOption2">选项2</label>
											<div class="controls">
												<textarea class="form-control" name="quOption2" rows="3" ></textarea>
												<p class="help-block">请输入选项2.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="quOption3">选项3</label>
											<div class="controls">
												<textarea class="form-control" name="quOption3" rows="3" ></textarea>
												<p class="help-block">请输入选项3.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
											<div class="control-group">											
											<label class="control-label" for="quOption4">选项4</label>
											<div class="controls">
												<textarea class="form-control" name="quOption4" rows="3" ></textarea>
												<p class="help-block">请输入选项4.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="quOption1Score">选项1分值</label>
											<div class="controls">
												<input type="text" class="input-medium" name="quOption1Score" value="" />
												<p class="help-block">请输入选项1分值.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="quOption2Score">选项2分值</label>
											<div class="controls">
												<input type="text" class="input-medium" name="quOption2Score" value="" />
												<p class="help-block">请输入选项2分值.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="quOption3Score">选项3分值</label>
											<div class="controls">
												<input type="text" class="input-medium" name="quOption3Score" value="" />
												<p class="help-block">请输入选项3分值.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="quOption4Score">选项4分值</label>
											<div class="controls">
												<input type="text" class="input-medium" name="quOption4Score" value="" />
												<p class="help-block">请输入选项4分值.</p>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
											<br />
										
											
										<div class="form-actions">
											<button type="submit" class="btn btn-primary">添加</button> 
											<button class="btn"><a href="exam-list.action">返回</a></button>
										</div> <!-- /form-actions -->
									</fieldset>
								</form>
								</div>
								
							</div>
						 	  
						</div>		
								
							</div> <!-- /widget-content -->
							
						</div> <!-- /widget -->
						
					</div> <!-- /span9 -->
					
				</div> <!-- /row -->
				
				
			</div> <!-- /span9 -->
			
			
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
