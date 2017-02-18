<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/etc" prefix="etc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/proscenium/js/jquery-1.11.2.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap-theme.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap.css" />

<link
	href="${pageContext.request.contextPath}/resources/proscenium/css/owl.carousel.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/npm.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/proscenium/css/style.css" />
<script
	src="${pageContext.request.contextPath}/resources/proscenium/js/owl.carousel.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/proscenium/js/jquery.raty.js"
		type="text/javascript"></script>

<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			items : 4,
			lazyLoad : true,
			autoPlay : true,
			navigation : true,
			navigationText : [ "", "" ],
			rewindNav : false,
			scrollPerPage : false,
			pagination : false,
			paginationNumbers : false,
		});
	});
</script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
</script>
<script type="text/javascript">
	var x = new Array;
	x = [ "#C62F2F", "#EFEFEF", "#EA6060", "aquamarine", "#EBF876", "#6CCACB",
			"#CB4DC9" ];
	x.sort(function() {
		return Math.random() - 0.5
	});
	$(document).ready(function() {
		$("#jumbotron1").css("background-color", x[0]);
		$("#jumbotron2").css("background-color", x[1]);
		$("#jumbotron3").css("background-color", x[2]);
	});
</script>

</head>

<body>
	<div class="header_bg">
		<div class="wrap">
			<div class="header">
				<div class="logo">
					<a href="index"> <img
						src="${pageContext.request.contextPath}/resources/proscenium/img/lg.png"
						alt="" />
						<h1>心理健康网</h1>
						<div class="clear"></div> </a>
				</div>
				<div class="text">
					<c:if test="${sessionScope.user1==null }">
						<a href="${pageContext.request.contextPath}/login.jsp"><p>登录</p>
						</a>
					</c:if>
					<c:if test="${sessionScope.user1!=null }">
						<p>当前用户：${sessionScope.user1.userName },<a href="loginout">注销</a></p>
						</a>
					</c:if>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="header_btm">
		<div class="wrap">
			<div class="header_sub">
				<div class="h_menu">
					<ul>
						<li><a href="index">主页</a>
						</li>
						<li><a href="book">读物</a>
						</li>
						<li><a href="article">心理咨讯文章</a>
						</li>
						<!--<li><a href="movies.html">影视</a></li>-->
						<li class="active"><a href="test">心理测试</a>
						</li>
						<li><a href="private">私人空间</a>
						</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>

	<div class="test">
		<div class="wrap">
			<c:forEach items="${examList.rows}" var="vo" varStatus="count">
				<h5 class="heading">
					<c:if test="${vo.num==1}">身心健康</c:if>
					<c:if test="${vo.num==2}">性格</c:if>
					<c:if test="${vo.num==3}">爱情</c:if>
					<c:if test="${vo.num==4}">职场</c:if>
					<c:if test="${vo.num==5}">人际交往</c:if>
				</h5>
				<div class="jumbotron" id="jumbotron${count.count }">
					<div class="container">
						<div class="center-block">
							<center>
								<h1>${vo.examTitle }</h1>
							</center>
						</div>
						<div class="center-block">
							<center>
								<h2>
									<span style="color:#000000;width:150px;overflow:hidden;text-overflow: ellipsis;white-space: nowrap;display: inline-block;">
										<small>${vo.examIntrd }</small> 
									</span>
								</h2>
							</center>
						</div>
						<!--<div class="center-block">
							  <h3 style="color: #337ab7;text-align: center;">试卷评分：</h3>

						</div>-->
						<div class="center-block"
							style="height: 200px;width: 200px;padding-top: 100px;">
							<p>
								<a class="btn btn-primary btn-lg btn-block btn-success"
									href="questionList?examNo=${vo.examNo }&page=1" role="button"
									data-test = "test" data-toggle="modal" id="testModal" data-target="#myModal${count.count }">开始测试>></a>
							</p>
							<!--  <p>
								<a class="btn btn-primary btn-lg btn-block btn-warning" href="#"
									role="button">评分>></a>
							</p>-->
						</div>
					</div>
				</div>

				<div class="modal fade" id="myModal${count.count }" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">${examTitle }</h4>
							</div>
							<div class="modal-body">
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="footer" style="width: 100%;height: 100%;">
		<div class="wrap">
			<div class="footer-left"
				style="float: left;width: 48%;margin-right: 4%;">
				<h3>关于我们</h3>
				<p>制作人：吉首大学邹宏图</p>
				<p>指导老师：廖晟微</p>
			</div>
			<div class="footer-right" style="float: right;width: 48%;">
				<h3>联系我们</h3>
				<p>联系电话：13574488126</p>
				<p>qq：392120454</p>
			</div>
			<div class="clear"></div>
			<hr />
			<center>
				<p style="font-size: 0.89em;color:#fff;line-height: 1.8em;">制作时间：20160812</p>
			</center>
		</div>
	</div>
	<a href="#to-top" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span>
	</a>
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
			scrollTop = document.documentElement.scrollTop
					|| window.pageYOffset || document.body.scrollTop;
			obj.style.display = (scrollTop >= 300) ? "block" : "none";
		}
		
		$("#testModal").click(function(){
			$(".modal-body").append("<jsp:include page='MyJsp.jsp'></jsp:include>");
		});
	</script>
</body>

</html>