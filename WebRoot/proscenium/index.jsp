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
		<title>心理健康网站</title>
		<link rel="icon" href="favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		<link rel="bookmark" href="favicon.ico" type="image/x-icon" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/jquery-1.11.2.min.js" ></script>
		<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" />
		<link href="${pageContext.request.contextPath}/resources/proscenium/css/owl.carousel.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/ js/bootstrap.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.2-dist/js/npm.js" ></script>
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
		<!-- //Owl Carousel Assets -->
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
							<li class="active"><a href="index">主页</a></li>
							<li><a href="book">读物</a></li>
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
		<div class="container">
		<div style="width: 90%; height: 100%; margin-right: auto; margin-left: auto;margin-top: 30px;">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000" >
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			  </ol>
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="${pageContext.request.contextPath}/resources/proscenium/img/cover.jpg" alt="..." style="width: 100%; height: 680px;">
			      <div class="carousel-caption">
			        <h3>1</h3>
			        <p>2334345234554</p>
			      </div>
			    </div>
			    <div class="item">
			      <img src="${pageContext.request.contextPath}/resources/proscenium/img/banner.jpg" alt="..."style="width: 100%; height: 680px">
			      <div class="carousel-caption">
			        <h3>1</h3>
			        <p>2334345234554</p>
			      </div>
			    </div>
			    <div class="item">
			      <img src="${pageContext.request.contextPath}/resources/proscenium/img/client-1.jpg" alt="..."style="width: 100%; height: 680px">
			      <div class="carousel-caption">
			        <h3>1</h3>
			        <p>2334345234554</p>
			      </div>
			    </div>
			  </div>
			
			  <!-- Controls -->
			  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		</div>
		
		<div class="Daily recommendations"><!-- start services -->
				<div class="wrap">
				<div class="Recent-wrok">
					<h5 class="heading">每日推荐</h5>
					<!----start-img-cursual---->
					<div id="owl-demo" class="owl-carousel" style="">
						<c:forEach items="${bookList}" var="vo">
						<div class="item1">
							<div class="cau_left">
								<img src="${vo.bookPic }" style="width:200px;height:200px" >
							</div>
							<div class="cau_left" >
								<h4><a href="#">${vo.bookName }</a></h4>
								<p style="height:250px;text-overflow: ellipsis;">
									${vo.bookIntrd }
								</p>
							</div>
						</div>
						</c:forEach>
						<c:if test="${fn:length(bookList)<3}"><h3 style="color: #337ab7;text-align: center;white-space: nowrap;display: inline-block;">您的信息不完整,系统只能给你推荐这些了┭┮﹏┭┮</h3></c:if>
					</div>
					<!----//End-img-cursual---->
				</div>
				</div>
			</div>
		
		
		<div class="Article" style="margin-top: 25px;width: 100%;height: 100%;"><!-- start services -->
			<div class="wrap">
				<div class="article">
					<h5 class="heading">文章阅览</h5>
					<!----start-img-cursual---->
						<ul class="media-list">
						  	<c:forEach items="${articleList}" var="vo">
						  	<li class="media">
						    	<div class="media-left">
						      		<a href="#">
						        		<img class="media-object" src="${vo.articlePic }" alt="..."style="width: 64px;height: 64px;max-width: none;">
						      		</a>
						    	</div>
						    	<div class="media-body">
						      		<h3 class="media-heading"><a href="page?page=${vo.articleNo }"style="text-decoration: none;">${vo.articleTitle }</a></h3>
						      		<pre>${vo.articleContent }</pre>
						    	</div>
						  	</li>
						  	</c:forEach>
						</ul>
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

