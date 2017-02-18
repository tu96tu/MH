<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
a,img{border:0;}

p{margin:20px 0 10px 0;}
</style>
<script src="${pageContext.request.contextPath}/resources/proscenium/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/proscenium/js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/proscenium/js/jquery.raty.js" type="text/javascript"></script>
  </head>
  
  <body>
   <div style="width:400px;margin:50px auto;">
	<p style="font-size:20px">请给出你的评分(百分制)：</p>
	<div id="star1"></div>
	<div id="result1"></div>
	<p style="font-size:20px">请给出你的评分(十分制)：</p>
	<div id="star2"></div>
	<div id="result2"></div>
</div>

<script type="text/javascript">
rat('star1','result1',10);
rat('star2','result2',1);
function rat(star,result,m){

	star= '#' + star;
	result= '#' + result;
	$(result).hide();//将结果DIV隐藏

	$(star).raty({
		hints: ['10','20', '30', '40', '50','60', '70', '80', '90', '100'],
		path: "resources/proscenium/img",
		starOff: 'star-off-big.png',
		starOn: 'star-on-big.png',
		size: 24,
		start: 40,
		showHalf: true,
		target: result,
		targetKeep : true,//targetKeep 属性设置为true，用户的选择值才会被保持在目标DIV中，否则只是鼠标悬停时有值，而鼠标离开后这个值就会消失
		click: function (score, evt) {
			//第一种方式：直接取值
			alert('你的评分是'+score*m+'分');
		}
	});

	/*第二种方式可以设置一个隐蔽的HTML元素来保存用户的选择值，然后可以在脚本里面通过jQuery选中这个元素来处理该值。 弹出结果
	var text = $(result).text();
	$('img').click(function () {
		if ($(result).text() != text) {
			alert('你的评分是'+$(result).text()/m+'分');
			alert(result);
			return;
		}
	});*/
}
</script>
</div>
  </body>
</html>
