<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/etc" prefix="etc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" href="favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		<link rel="bookmark" href="favicon.ico" type="image/x-icon" />
		<title>心理健康网站</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/jquery-1.11.2.min.js" ></script>
		<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap.min.css" />
		<link href="${pageContext.request.contextPath}/resources/proscenium/css/owl.carousel.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/ js/bootstrap.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/npm.js" ></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/css/style.css" />
		<script src="${pageContext.request.contextPath}/resources/proscenium/js/owl.carousel.js"></script>
	<script>
			$(document).ready(function() {
				$("#owl-demo").owlCarousel({
					items : 4,
					lazyLoad : true,
					autoPlay : true,
					navigation : true,
					navigationText : ["", ""],
					rewindNav : false,
					scrollPerPage : false,
					pagination : false,
					paginationNumbers : false,
				});
			});
		</script>
		<script type="text/javascript">
			$(function(){
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
				$(".bl").css("display","none");
				$(".div").css("width","100%");
				$(".div").css("height","34px");
				$(".div").css("line-height","34px");
				$(".div").dblclick(function(){
					$(".div").css("display","none");
					$(".bl").css("display","block");
				});
				$(".cancel").click(function(){
					$(".div").css("display","block");
					$(".bl").css("display","none");
				})
			});
</script>
<script>
	$(function(){
		var error = $(".text-center").text();
		if(""==error){
			$(".li1").removeClass("active");
			$(".li2").removeClass("active");
			$("#home").removeClass("active");
			$("#message").removeClass("active");
			$("#home").addClass("active");	
			$(".li1").addClass("active");		
		}else{
			$(".li1").removeClass("active");
			$(".li2").removeClass("active");
			$("#home").removeClass("active");
			$("#message").removeClass("active");
			$("#message").addClass("active");	
			$(".li2").addClass("active");
		}
	});
</script>
	</head>
	<body>
		<div class="header_bg">
			<div class="wrap">
				<div class="header">
					<div class="logo">
						<a href="index">
							<img src="${pageContext.request.contextPath}/resources/proscenium/img/lg.png" alt=""/>
							<h1>心理健康网</h1>
							<div class="clear"> </div>
						</a>
					</div>
					<div class="text">
					  <c:if test="${sessionScope.user1==null }"><a href="${pageContext.request.contextPath}/login.jsp"><p>登录</p></a></c:if>
					  <c:if test="${sessionScope.user1!=null }"><p>当前用户：${sessionScope.user1.userName },<a href="loginout">注销</a></p></c:if>
					</div>
					<div class="clear"> </div>
				</div>
			</div>
		</div>
		<div class="header_btm">
			<div class="wrap">
				<div class="header_sub">
					<div class="h_menu">
						<ul>
							<li><a href="index">主页</a></li>
							<li><a href="book">读物</a></li>
							<li><a href="article">心理咨讯文章</a></li>
							<!--<li><a href="movies.html">影视</a></li>-->
							<li><a href="test">心理测试</a></li>
							<li class="active"><a href="private">私人空间</a></li>
						</ul>
					</div>
					<div class="clear"> </div>
				</div>
			</div>
		</div>
		
		<div class="Daily recommendations" style="margin-top: 75px;width: 100%;height: 100%;"><!-- start services -->
			<div class="wrap">
				<div class="Daily-recommendation">
					<h5 class="heading">私人空间</h5>
					<!----start-img-cursual---->
					<div class="row">
					  	<div>
					  	<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
							    <li role="presentation" class="li1 active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">基本信息</a></li>
							    <li role="presentation" class="li2"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">收藏列表</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
							    <div role="tabpane1" class="tab-pane active" id="home">
									<form class="form-horizontal" method="post" action="userModify?userNo=${user1.userNo }" style="padding-top: 35px;width: 80%;">
										<fieldset>
										<div class="control-group" style="width: 100%;">
									  	<div class="form-group">
									    	<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
									    	<div class="col-sm-10">
									      		<input type="text" class=" form-control bl" id="userName" name="userName" placeholder="用户名" value="${user1.userName }" disabled>
									      		<span class="div">${user1.userName }</span>
									    	</div>
									  	</div>
									  	</div>
									  	
									  	<div class="form-group">
									    	<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
									    	<div class="control-group" style="width: 100%;">
										    <div class="col-sm-10">
										      	<input type="password" class=" form-control bl" id="userPwd"  name="userPwd" placeholder="密码" value="${user1.userPwd }">
										      	<span class="div">***</span>
										    </div>
									  	</div>
									  	</div>
									  	
									  	<div class="form-group">
									    	<label for="inputEmail3" class="col-sm-2 control-label">真实姓名</label>
									    	<div class="control-group" style="width: 100%;">
									    	<div class="col-sm-10">
									      		<input type="text" class="form-control bl" id="userRealName" name="userRealName" placeholder="真实姓名" value="${user1.userRealName }">
									      			<span class="div">${user1.userRealName }</span>
									    	</div>
									  	</div>
									  	</div>
									  	<div class="control-group" style="width: 100%;">
									  	<div class="form-group">
									  		<label for="inputEmail3" class="col-sm-2 control-label">性别</label>
									  		<div class="col-sm-10 bl">
									  			<c:if test="${user1.userSex }">
									    		<label class="radio-inline ">
												  	<input type="radio" name="userSex" id="userSex" value="true" checked="checked"> 男
												</label>
												<label class="radio-inline ">
												  	<input type="radio" name="userSex" id="userSex" value="false"> 女
												</label>
												</c:if>
												<c:if test="${!user1.userSex }">
									    		<label class="radio-inline ">
												  	<input type="radio" name="userSex" id="userSex" value="true" > 男
												</label>
												<label class="radio-inline ">
												  	<input type="radio" name="userSex" id="userSex" value="false" checked="checked"> 女
												</label>
												</c:if>
											</div>
											<div class="col-sm-10 ">
											<span class="div"><c:if test="${user1.userSex }">男</c:if><c:if test="${!user1.userSex }">女</c:if></span>
											</div>
									  	</div>
									  	</div>
									  	
									  	<div class="form-group">
									    	<label for="inputEmail3" class="col-sm-2 control-label">年龄</label>
									    	<div class="control-group" style="width: 100%;">
									    	<div class="col-sm-10">
									      		<input type="text" class="form-control bl" id="userAge" name="userAge" placeholder="年龄" value="${user1.userAge }">
									      			<span class="div">${user1.userAge }</span>
									    	</div>
									  	</div>
									  	</div>
									  	<div class="control-group" style="width: 100%;">
									  	<div class="form-group">
									    	<label for="inputEmail3" class="col-sm-2 control-label">联系电话</label>
									    	<div class="col-sm-10">
									      		<input type="text" class="form-control bl" id="userTel" name="userTel" placeholder="联系电话" value="${user1.userTel }">
									      			<span class="div">${user1.userTel }</span>
									    	</div>
									  	</div>
									  	</div>
									  	<div class="control-group" style="width: 100%;">
									  	<div class="form-group">
										    <div class="col-sm-offset-2 col-sm-10 bl">
										      	<button type="submit" class="btn btn-primary">保存</button>
										      	<button type="reset" class="btn btn-info cancel">取消</button>
										    </div>
									  	</div>
									  	</div>
									  	</fieldset>
									</form>
							    </div>

							    <div role="tabpanel" class="tab-pane" id="messages">
							    	<div class="coll" style="padding-top: 40px;">
							    	<div class="panel panel-info" >
									  <!-- Default panel contents -->
									  <div class="panel-heading">收藏列表</div>
										<div class="text-center" style="color: red">${message }</div>
									  <!-- Table -->
									  <table class="table table-striped table-hover">
									  	<thead>
									  		<tr>
									  			<th>文章标题</th>
									  			<th>收藏日期</th>
									  			<th>操作</th>
									  		</tr>
									  	</thead>
									    <tbody>
									    	<c:forEach items="${collection}" var="vo">
									    	<tr>
									    		<td><a href="page?page=${vo.articleNo }">${vo.articleNo }</a></td>
									    		<td>${vo.collDate }</td>
									    		<td><a onclick="return confirm('您确定要取消收藏该文章吗？')" class="btn btn-danger btn-xs" href="collectDelete?collNo=${vo.collNo }"><i class="glyphicon glyphicon-remove"></i> 取消收藏</a></td>
									    	</tr>
									    	</c:forEach>
									    </tbody>
									  </table>
									</div>
							    
							    	</div>
								</div>	
							</div>
						</div>
					</div>
					<!----//End-img-cursual---->
				</div>
			</div>
		</div>
		
		<div class="footer" style="width: 100%;height: 100%;">
			<div class="wrap">
				<div class="footer-left" style="float: left;width: 48%;margin-right: 4%;">
					<h3>关于我们</h3>
					<p>制作人：吉首大学邹宏图</p>
					<p>指导老师：廖晟微</p>
				</div>
				<div class="footer-right" style="float: right;width: 48%;">
					<h3>联系我们</h3>
					<p>联系电话：13574488126</p>
					<p>qq：392120454</p>
				</div>
				<div class="clear"> </div>	
				<hr/>
				<center><p style="font-size: 0.89em;color:#fff;line-height: 1.8em;">制作时间：20160812</p></center>
			</div>
		</div>
		<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>	
		<script type="text/javascript">
		    // 获取置顶对象
		    var obj = document.getElementById('toTop');
		    var scrollTop = null;
		
		    // 置顶对象点击事件
		    obj.onclick = function() {
		        var timer = setInterval(function() {
		            window.scrollBy(0, -20);
		            if (scrollTop == 0) 
		                clearInterval(timer);
		        }, 2);
		    }
		
		    // 窗口滚动检测
		    window.onscroll = function() {
		        scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
		        obj.style.display = (scrollTop >= 300) ? "block" : "none";
		    }
		</script>
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
				
				form.find("[name='userTel']").on("keyup",function(){
					var the = $(this);
					if(/^13[0-9]{9}$/.test(the.val())){
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
				
				
				form.find("[name='userRealName']").on("keyup",function(){
					var the = $(this);
					if(/^([\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*)|([a-zA-Z]+)$/.test(the.val())){
						the.parents(".control-group:first").removeClass("has-error").addClass("has-success");
					}else{
						the.parents(".control-group:first").addClass("has-error");
					}
				});
				
			});
		})(jQuery);
		</script>
	</body>
</html>

