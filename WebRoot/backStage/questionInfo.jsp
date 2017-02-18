<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/etc" prefix="etc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
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
					
					<li >
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
					<i class="icon-home"></i>
					试卷信息管理					
				</h1>	
				<div class="plan-features">
						<form method="post" action="question-search" id="edit-profile" class="form-horizontal">
							<fieldset>
								<div class="control-group">											
									<div class="controls">
										<input type="text" class="input-medium" name="questionMessage" value="" placeholder="你可以对题目编号或者题目标题进行模糊搜索" style="width:500px"/>
										<button type="submit" class="btn btn-primary">搜索</button> 
										<button  class="btn "><a href="backStage/question-add.jsp?examNo=${sessionScope.examNo }" style="text-decoration: none">添加试题</a></button> 
									</div> <!-- /controls -->				
								</div> <!-- /control-group -->
							</fieldset>
						</form>
				</div>
					
				<div class="widget widget-table">
										
					<div class="widget-header">
						<i class="icon-th-list"></i>
						<h3>题目信息表</h3>
					</div> <!-- /widget-header -->
					
					<div class="widget-content">
					
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th width="5%">题目编号</th>
									<th width="10%">题目标题</th>
									<th width="12.5%">选项1</th>
									<th width="12.5%">选项2</th>
									<th width="12.5%">选项3</th>
									<th width="12.5%">选项4</th>
									<th width="5%">选项1分值</th>
									<th width="5%">选项2分值</th>
									<th width="5%">选项3分值</th>
									<th width="5%">选项4分值</th>
									<th width="15%">操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${pageVO.rows }" var="vo" varStatus="count">
								<tr>
									<td>${vo.quNo }</td>
									<td>${vo.quTitle }</td>
									<td>${vo.quOption1 }</td>
									<td>${vo.quOption2 }</td>
									<td>${vo.quOption3}</td>
									<td>${vo.quOption4}</td>
									<td>${vo.quOption1Score}</td>
									<td>${vo.quOption2Score}</td>
									<td>${vo.quOption3Score}</td>
									<td>${vo.quOption4Score}</td>
									<td><a href="question-modify1?quNo=${vo.quNo }" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-tags" ></i> 修改</a>
									<a onclick="return confirm('您确定要删除该题目信息吗？')" class="btn btn-danger btn-xs" href="question-delete?quNo=${vo.quNo }"><i class="glyphicon glyphicon-remove"></i> 删除</a>   
									 </td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						
					</div> <!-- /widget-content -->
					<div class="text-center" >
							${error }
					</div>
					<div class="text-center" >
							<etc:page url="question-list?pages={page}" page="${pageVO }"/>
					</div>
					
				</div> <!-- /widget -->


<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/backStage/js/jquery-1.7.2.min.js"></script>


<script src="resources/backStage/js/bootstrap.js"></script>
<script src="resources/backStage/js/faq.js"></script>

<script>

$(function () {
	
	$('.faq-list').goFaq ();
	
});

</script>
  </body>
</html>
