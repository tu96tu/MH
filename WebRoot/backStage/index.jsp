<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.tutu.vo.PageVO"%>
<%@ taglib uri="/etc" prefix="etc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
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
							${sessionScope.userName } <b class="caret"></b>							
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


<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>

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
					<i class="icon-home"></i>
					用户信息管理				
				</h1>
				<div class="plan-features">
						<form method="post" action="user-search" id="edit-profile" class="form-horizontal">
							<fieldset>
								<div class="control-group">											
									<div class="controls">
										<input type="text" class="input-medium" name="searchMessage" value="" placeholder="根据用户名或者真实姓名或者电话号码进行模糊搜索" style="width:500px"/>
										<button type="submit" class="btn btn-primary">搜索</button> 
										<button  class="btn "><a href="backStage/user-add.jsp" style="text-decoration: none">添加用户</a></button> 
									</div> <!-- /controls -->				
								</div> <!-- /control-group -->
							</fieldset>
						</form>
				</div>
					
				<div class="widget widget-table">
										
					<div class="widget-header">
						<i class="icon-th-list"></i>
						<h3>用户信息表</h3>
					</div> <!-- /widget-header -->
					
					<div class="widget-content">
					
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>用户名</th>
									<th>真实姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>心理类型</th>
									<th>电话号码</th>
									<th>角色</th>
									<th>锁定状态</th>
									<th>操作</th>
								</tr>
							</thead>
							
							<tbody>
							<c:forEach items="${list }" var="vo">
								<tr>
									<td>${count.count }</td>
									<td>${vo.userName }</td>
									<td>${vo.userRealName }</td>
									<td>
										<c:if test="${vo.userSex }">男</c:if>
										<c:if test="${!vo.userSex }">女</c:if>
									</td>
									<td>${vo.userAge }</td>
									<td>
									<c:if test="${vo.num==0}">null</c:if>
									<c:if test="${vo.num==1}">身心健康</c:if>
									<c:if test="${vo.num==2}">性格</c:if>
									<c:if test="${vo.num==3}">爱情</c:if>
									<c:if test="${vo.num==4}">职场</c:if>
									<c:if test="${vo.num==5}">人际交往</c:if>
									</td>
									<td>${vo.userTel }</td>
									<td class="action-td">
										<c:if test="${vo.userRole }">管理员</c:if>
										<c:if test="${!vo.userRole }">普通用户</c:if>
									</td>
									<td class="action-td">
										<c:if test="${!vo.userLock }">锁定</c:if>
										<c:if test="${vo.userLock }">未锁定</c:if>
									</td>
									<td><a href="user-modify1?userNo=${vo.userNo }" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-tags" ></i> 修改</a>
										<a onclick="return confirm('您确定要锁定/解锁该用户吗？')" href="user-lock?userNo=${vo.userNo }" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-tags" ></i>  <c:if test="${!vo.userLock }">解锁</c:if><c:if test="${vo.userLock }">锁定</c:if></a>
										<a onclick="return confirm('您确定要删除该用户信息吗？')" class="btn btn-danger btn-xs" href="user-delete?userNo=${vo.userNo }"><i class="glyphicon glyphicon-remove"></i> 删除</a>    </td>
								</tr>
								</c:forEach>
								<c:forEach items="${pageVO.rows }" var="vo" varStatus="count">
								<tr>
									<td>${count.count }</td>
									<td>${vo.userName }</td>
									<td>${vo.userRealName }</td>
									<td>
										<c:if test="${vo.userSex }">男</c:if>
										<c:if test="${!vo.userSex }">女</c:if>
									</td>
									<td>${vo.userAge }</td>
									<td>
									<c:if test="${vo.num==0}">null</c:if>
									<c:if test="${vo.num==1}">身心健康</c:if>
									<c:if test="${vo.num==2}">性格</c:if>
									<c:if test="${vo.num==3}">爱情</c:if>
									<c:if test="${vo.num==4}">职场</c:if>
									<c:if test="${vo.num==5}">人际交往</c:if>
									</td>
									<td>${vo.userTel }</td>
									<td class="action-td">
										<c:if test="${vo.userRole }">管理员</c:if>
										<c:if test="${!vo.userRole }">普通用户</c:if>
									</td>
									<td class="action-td">
										<c:if test="${!vo.userLock }">锁定</c:if>
										<c:if test="${vo.userLock }">未锁定</c:if>
									</td>
									<td><a href="user-modify1?userNo=${vo.userNo }" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-tags" ></i> 修改</a>
										<a onclick="return confirm('您确定要锁定/解锁该用户吗？')" href="user-lock?userNo=${vo.userNo }" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-tags" ></i>  <c:if test="${!vo.userLock }">解锁</c:if><c:if test="${vo.userLock }">锁定</c:if></a>
										<a onclick="return confirm('您确定要删除该用户信息吗？')" class="btn btn-danger btn-xs" href="user-delete?userNo=${vo.userNo }"><i class="glyphicon glyphicon-remove"></i> 删除</a>    </td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					
					</div> <!-- /widget-content -->
						
					<div class="text-center" >
							${error }
					</div>
					<div class="text-center" >
							<etc:page url="user-list?page={page}" page="${pageVO }"/>
					</div>
					
				</div> <!-- /widget -->
				


<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/backStage/js/jquery-1.7.2.min.js"></script>
<script src="resources/backStage/js/excanvas.min.js"></script>
<script src="resources/backStage/js/jquery.flot.js"></script>
<script src="resources/backStage/js/jquery.flot.pie.js"></script>
<script src="resources/backStage/js/jquery.flot.orderBars.js"></script>
<script src="resources/backStage/js/jquery.flot.resize.js"></script>


<script src="resources/backStage/js/bootstrap.js"></script>
<script src="resources/backStage/js/charts/bar.js"></script>
  </body>
</html>