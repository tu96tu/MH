<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/etc" prefix="etc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns:wb="http://open.weibo.com/wb">

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="favicon.ico">
		<link rel="icon" type="image/x-icon" href="favicon.ico" />
		<title>心理健康网站</title>
		<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/jquery-1.11.2.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/ js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/npm.js"></script>
		<script src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" charset="utf-8"></script>
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
							<img src="${pageContext.request.contextPath}/resources/proscenium/img/lg.png" alt="" />
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
							<li class="active"><a href="article?page=1">心理咨讯文章</a></li>
							<!--<li><a href="movies.html">影视</a></li>-->
							<li><a href="test">心理测试</a></li>
							<li><a href="private">私人空间</a></li>
						</ul>
					</div>
					<div class="clear"> </div>
				</div>
			</div>
		</div>

		<!--------start-blog----------->
		<div class="blog">
			<div class="main">
				<div class="wrap">
					<div class="single-top">
						<div class="wrapper_single">
							<c:forEach items="${articleList.rows}" var="vo" varStatus="count">
							<div class="wrapper_top">
								<div class="grid_1 alpha">
									<div class="date">
										<span>
										${fn:substring(vo.articleDate,5,10)}
									</span>
								 ${fn:substring(vo.articleDate,0,4)}
									</div>
								</div>
								<div class="content span_2_of_single">
									<h5 class="blog_title"><a href="page?page=${vo.articleNo }">${vo.articleTitle }</a></h5>
									<div class="content">
										<div class="span-1-of-1">
										<c:if test="${vo.articlePic!=null }"><a href="page?page=${vo.articleNo }"><img class="m_img"  src="${vo.articlePic }" alt=""/></a></c:if>
										<c:if test="${vo.articlePic==null }"><a href="page?page=${vo.articleNo }"><img class="m_img"  src="${pageContext.request.contextPath}/resources/proscenium/img/o.gif" alt="图片被服务器吞噬了"/></a></c:if>
										</div>
										<div class="span-1-of-2" >
											<p style="text-overflow:ellipsis;overflow:hidden;height: 190px">${vo.articleContent }</p>
											<a href="page?page=${vo.articleNo }" class="arrow_btn">了解更多</a>
										</div>
										<div class="clear"> </div>
									</div>
									<div class="links">
										<h3 class="comments">By<a href="#">&nbsp;${vo.articleAuthor }</a></h3>
										<h3 class="tags">标签: 
											<a href="#">
												<c:if test="${vo.num==0}"></c:if>
												<c:if test="${vo.num==1}">身心健康</c:if>
												<c:if test="${vo.num==2}">性格</c:if>
												<c:if test="${vo.num==3}">爱情</c:if>
												<c:if test="${vo.num==4}">职场</c:if>
												<c:if test="${vo.num==5}">人际交往</c:if>
											</a>
										</h3>
										<h3>分享</h3>
										<h3>
										<wb:share-button addition="number" type="button" default_text="。。。。毕设" ralateUid="5387362697"></wb:share-button>
										<script type="text/javascript">
											(function(){
											var p = {
											url:location.href,
											showcount:'1',/*是否显示分享总数,显示：'1'，不显示：'0' */
											desc:'这个网站真棒！',/*默认分享理由(可选)*/
											summary:'哦',/*分享摘要(可选)*/
											title:'这只是一个测试',/*分享标题(可选)*/
											site:'MH心理健康网',/*分享来源 如：腾讯网(可选)*/
											pics:'', /*分享图片的路径(可选)*/
											style:'102',
											width:145,
											height:30
											};
											var s = [];
											for(var i in p){
											s.push(i + '=' + encodeURIComponent(p[i]||''));
											}
											document.write(['<a version="1.0" class="qzOpenerDiv" href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?',s.join('&'),'" target="_blank">分享</a>'].join(''));
											})();
										</script>
									</h3>
										<div class="clear"> </div>
									</div>
								</div>
								<div class="clear"> </div>
							</div>
							
							</c:forEach>
							<c:if test="${fn:length(articleList.rows)<3&&error==null}"><h3 style="color: #337ab7;text-align: center;">没有啦,这里是最后一页ლ(╹◡╹ლ)...</h3></c:if>
							<c:if test="${error!=null }"><h3 style="color: #337ab7;text-align: center;"><img class="m_img"  src="${pageContext.request.contextPath}/resources/proscenium/img/ditou.jpg"/>${error}</h3></c:if>
							<c:if test="${error==null }">
								<c:if test="${key==null}">
									<nav>
										<ul class="pager">
											<li><a  href="article?page=${articleList.current-1 }">上页</a></li>
											<li><a href="article?page=${articleList.current+1 }">下页</a></li>
										</ul>
									</nav>
								</c:if>
								<c:if test="${key==1 }">
									<nav>
										<ul class="pager">
											<li><a  href="articleSearch?page=${articleList.current-1 }">上页</a></li>
											<li><a href="articleSearch?page=${articleList.current+1 }">下页</a></li>
										</ul>
									</nav>
								</c:if>
								<c:if test="${key==2 }">
									<nav>
										<ul class="pager">
											<li><a  href="articleSearchByNum?page=${articleList.current-1 }&&num=${num}">上页</a></li>
											<li><a href="articleSearchByNum?page=${articleList.current+1 }&&num=${num}">下页</a></li>
										</ul>
									</nav>
								</c:if>
							</c:if>
						</div>
						<div class="rsidebar span_1_of_3">
							<div class="search_box">
								<form method="post" action="articleSearch">
									<input type="text" name="articleMessage" placeholder="输入:文章标题/作者" value="" >
									<input type="submit" value="">
								</form>
							</div>
							<div class="Categories">
								<h4>目录</h4>
								<ul class="sidebar">
									<c:forEach items="${articleMenu.rows}" var="vo" varStatus="count">
									<div class="hover">
										<li><a href="page?page=${vo.articleNo }">${vo.articleTitle }</a></li>
									</div>
									</c:forEach>
								</ul>
							</div>
							<div class="tags">
								<h4>标签</h4>
								<ul>
									<li><a href="articleSearchByNum?num=1">身心健康</a></li>
									<li><a href="articleSearchByNum?num=3">爱情</a></li>
									<li><a href="articleSearchByNum?num=4">职场</a></li>
									<li><a href="articleSearchByNum?num=2">性格</a></li>
									<li><a href="articleSearchByNum?num=5">人际交往</a></li>
									<div class="clear"> </div>
								</ul>
							</div>
						</div>
						<div class="clear"> </div>
					</div>
					
					<!----//End-content---->
				</div>
			</div>
		</div>
		<!--------//end-blog----------->

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
				<center>
					<p style="font-size: 0.89em;color:#fff;line-height: 1.8em;">制作时间：20160812</p>
				</center>
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