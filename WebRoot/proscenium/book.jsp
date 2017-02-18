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
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/ js/bootstrap.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/npm.js" ></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/css/style.css" />
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
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
							<li ><a href="index">主页</a></li>
							<li class="active"><a href="book">读物</a></li>
							<li><a href="article?page=1">心理咨讯文章</a></li>
							<!--<li><a href="movies.html">影视</a></li>-->
							<li><a href="test">心理测试</a></li>
							<li><a href="private">私人空间</a></li>
						</ul>
					</div>
					<div class="clear"> </div>
				</div>
			</div>
		</div>
		
		<div class="Daily recommendations" style="margin-top: 75px;width: 100%;height: 100%;">	
		<!-- start services -->
			<div class="wrap">
				<div class="Daily-recommendation">
					<h5 class="heading">读物信息</h5>
					<div class="search_box" style="border-color: #21B7C6;">
					<form action="bookSearch" method="post">
		    			<input type="text" name="bookMessage"value="" placeholder="search something...">
		    			<input type="submit" value="">
		    		</form>
					</div>
					<!----start-img-cursual---->
					<div class="row" style="padding-top: 25px;">
						<c:forEach items="${list}" var="vo">
						  	<div class="col-sm-6 col-md-4" >
							    <div class="thumbnail">
							      <img src="${vo.bookPic }" alt="..." style="width:200px;height:200px">
							      <div class="caption">
							        <h3>${vo.bookName }</h3>
							        <p style="height:200px;text-overflow: ellipsis;">${vo.bookIntrd }</p>
							        <!-- <p><a href="#" class="btn btn-primary" role="button">详情</a> <a href="#" class="btn btn-default" role="button">Button</a></p> -->
							      </div>
							    </div>
						  	</div>
					  	</c:forEach>
					  	<c:forEach items="${bookList.rows}" var="vo">
						  	<div class="col-sm-6 col-md-4" >
							    <div class="thumbnail">
							      <img src="${vo.bookPic }" alt="..." style="width:200px;height:200px">
							      <div class="caption">
							        <h3>${vo.bookName }</h3>
							        <p style="height:200px;text-overflow: ellipsis;">${vo.bookIntrd }</p>
							        <!--<p><a href="#" class="btn btn-primary" role="button">详情</a> <a href="#" class="btn btn-default" role="button">Button</a></p>  -->
							      </div>
							    </div>
						  	</div>
					  	</c:forEach>
						 <nav style="padding-top: 35px;">
					        <c:if test="${fn:length(list)==6}">
					        	<ul class="pager">
								    <li class="previous"><h3 style="color: #337ab7;text-align: center;">全部加载完啦~只有一页哦~\(≧▽≦)/~...</h3></li>
							 	 </ul>
					        </c:if>
					        <c:if test="${bookList.current==1&&fn:length(list)>6}">
					        	<ul class="pager">
								    <li class="previous"><h3 style="color: #337ab7;text-align: center;">当前为第一页</h3></li>
								    <li class="next"><a href="book?page=${bookList.current+1 }">下一页 <span aria-hidden="true">&rarr;</span></a></li>
							 	 </ul>
					        </c:if>
					         <c:if test="${fn:length(list)==bookList.current}">
					        	<ul class="pager">
								    <li class="previous"><a href="book?page=${bookList.current-1 }"><span aria-hidden="true">&larr;</span> 上一页</a></li>
								    <li class="next"><h3 style="color: #337ab7;text-align: center;">当前为最后一页</h3></li>
							 	 </ul>
					        </c:if>
					        <c:if test="${bookList.current>=1&&fn:length(list)!=bookList.current}">
					        	<ul class="pager">
								     <li class="previous"><a href="book?page=${bookList.current-1 }"><span aria-hidden="true">&larr;</span> 上一页</a></li>
								    <li class="next"><a href="book?page=${bookList.current+1 }">下一页<span aria-hidden="true">&rarr;</span></a></li>
							 	 </ul>
					        </c:if>
							 
							</nav>
					</div>
					<div><h3 style="color: #337ab7;text-align: center;">${error }</h3></div>
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
	</body>
</html>
