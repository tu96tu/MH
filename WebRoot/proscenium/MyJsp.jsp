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
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
a,img{border:0;}

p{margin:20px 0 10px 0;}
	</style>
	<script src="${pageContext.request.contextPath}/resources/proscenium/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/proscenium/js/jquery.raty.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/proscenium/js/jquerysession.js"></script>
<script type="text/javascript">
	$(function(){
		$.session.set("page",1);
	});
	function testSubmit(which){
		var page = $("#pages").val();
		var examNo = $("#examNo").val();
		var testScore = parseInt($("#testScore").val())+parseInt($(which).val());
		$.ajax({
			   type: "POST",
			   url: "testSubmit",
			   data: {"examNo":examNo,"testScore":testScore},
			   dataType:"json",
			   success: function(data){
			   		$("#formId").attr("action","resultSave");
			   		$(".modal-title").html("测试结果");
			   		$(".tt1").html("<p class=\"lead\">"+data.testResult+"</p>");
			   		$("#testResult").attr("value",data.testResult);
			   		if("0"!=data.userNo){
			   			$(".star_bg").css("display","block");
				   		$(".tt2").html("Tips:请点击保存按钮，否则测试结果无法保存哟~(*゜ー゜*)...");
				   		$(".modal-footer").html("<button type=\"submit\" class=\"btn btn-info\" >保存</button>");
				   	}else{
				   		$(".tt2").html("Tips:您还没有登录，不能保存测试结果哟~ㄟ( ▔, ▔ )ㄏ...");
				   		$(".modal-footer").html("<p><a class=\"btn btn-info\" href=\"login.jsp\" role=\"button\">前往登陆</a></p>");
				   	}
			   }	   
		});
	}
	function ajax(which){
		var page = $("#pages").val();
		var examNo = $("#examNo").val();
		var num = parseInt($("#testScore").val());
		$.session.set("page",page);
		//console.log($(which).val());
		$.ajax({
			   type: "POST",
			   url: "next",
			   data: {"page":page,"examNo":examNo},
			   dataType:"json",
			   success: function(data){
			   		$("#testScore").attr("value",parseInt($(which).val())+num);
			   		$("#pages").attr("value",data.page);
			   		$("#examNo").attr("value",data.examNo);
			   		$("#page").html(data.page+".");
			     	$(".control-label").html(data.quTitle);
			     	$("#span1").html(data.quOption1);
			     	$("#span2").html(data.quOption2);
			     	$("#span3").html(data.quOption3);
			     	$("#span4").html(data.quOption4);
			     	$("#quOption1").val(data.quOption1Score); 
			     	$("#quOption2").val(data.quOption2Score); 
			     	$("#quOption3").val(data.quOption3Score);
			     	$("#quOption4").val(data.quOption4Score);
			     	$("#quOption1").attr("checked",false);
			     	$("#quOption2").attr("checked",false);
			     	$("#quOption3").attr("checked",false);
			     	$("#quOption4").attr("checked",false);
			     	if(data.quOption1==""){
			     		$(".radio1").hide();
			     	}else{
			     		$(".radio1").show();
			     	}
			     	if(data.quOption2==""){
			     		$(".radio2").hide();
			     	}else{
			     		$(".radio2").show();
			     	}
			     	if(data.quOption3==""){
			     		$(".radio3").hide();
			     	}else{
			     		$(".radio3").show();
			     	}
			     	if(data.quOption4==""){
			     		$(".radio4").hide();
			     	}else{
			     		$(".radio4").show();
			     	}
			     	if(data.page>data.length-1){
			     		$("#quOption1").attr('onclick', '').unbind('click').click( function () { testSubmit(this); }); 
			     		$("#quOption2").attr('onclick', '').unbind('click').click( function () { testSubmit(this); });
			     		$("#quOption3").attr('onclick', '').unbind('click').click( function () { testSubmit(this); });
			     		$("#quOption4").attr('onclick', '').unbind('click').click( function () { testSubmit(this); });
			     	}
			   }	   
		});
		
	}
</script>
  </head>
  
  <body >
						<div class="modal-content">
							<div class="modal-header">
								<a href="test"><button type="button" class="close"  aria-label="Close"><span aria-hidden="true">&times;</span></button></a>
								<h4 class="modal-title" id="myModalLabel">${examTitle }</h4>
							</div>
							<div class="modal-body" style="background-image: url(${pageContext.request.contextPath}/resources/proscenium/img/101.jpg);">
							
								<form id="formId" method="post" action="test" class="form-horizontal">
									<div class="text-center tt1">
									<fieldset>
									
										<c:forEach items="${questionList.rows }" var="vo" varStatus="count">
										<div class="control-group" style="width: 100%;">
											<c:if test="${questionList.rows==null }"><h3 style="color: #337ab7;text-align: center;">试卷是空的，换其他试卷测试吧(≧∀≦)ゞ...</h3></c:if>
											<!-- Text input-->
											<div class="col-md-10">
													<span id="page"></span><label class="control-label">${count.count}.${vo.quTitle }</label>
													<input id="pages" type="hidden" value="1"/>
													<input id="examNo" type="hidden" value="1"/>
													<input id="testScore" name="testScore" type="hidden" value="0">
													<div class="radio1">
													<label>
														<input type="radio" name="quOption1" id="quOption1" value="${vo.quOption1Score }" onclick="ajax(this)">

														<span id="span1">${vo.quOption1 }</span>
													</label>
													</div>
													<div class="radio2">
													<label>

														<input type="radio" name="quOption2" id="quOption2" value="${vo.quOption2Score }" onclick="ajax(this)">

														<span id="span2">${vo.quOption2 }</span>
													</label>
													</div>
													<div class="radio3">
													<label>

														<input type="radio" name="quOption3" id="quOption3" value="${vo.quOption3Score }" onclick="ajax(this)">

														<span id="span3">${vo.quOption3 }</span>
													</label>
													</div>
													<div class="radio4">
													<label>
														<input type="radio" name="quOption4" id="quOption4" value="${vo.quOption4Score }" onclick="ajax(this)">

														<span id="span4">${vo.quOption4}</span>
													</label>
													</div>
											</div>
										</div>
									</c:forEach>
									</fieldset>
									</div>	 
									<div style="width:400px;margin:50px auto;display:none" class="star_bg">
										<p style="font-size:20px">请给出你对试卷的评分(十分制)：</p>
										<div id="star2"></div>
										<div id="result2"></div>
										<input id="testScore" name="testScore" type="hidden" value="0">
										<input id="testResult" name="testResult" type="hidden" value="">
									</div>
									
									<div class="text-center tt2" style="color:red"></div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-default" >取消测试</button>
									</div>
								</form>
								
							</div>
						</div>
						<script type="text/javascript">
							$(function(){
								var a=$("#span4").text();
								
								if(a.length==0){
									$(".radio4").hide();
									
								}
								var b=$("#span3").text();
								if(b.length==0){
								$(".radio3").hide();
									
								}
								var c=$("#span2").text();
								if(c.length==0){
								$(".radio2").hide();
									
								}
								var d=$("#span1").text();
								if(d.length==0){
								$(".radio1").hide();
									
								}
							});
						</script>
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
			$("#testScore").attr("value",score*m);
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
  </body>
</html>
