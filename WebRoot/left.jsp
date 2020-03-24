<%@page import="entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>推免成绩计算系统</title>
		<link rel="stylesheet" href="css/StudentLeft.css">
		
	</head>
	<body>
	<%Student onlinestudent=(Student) session.getAttribute("onlinestudent");%>
		<div class="nav" style="width: 260px; ">
			<div class="nav-list" style="width: 248px; ">
				<div class="nav-tit">
					<input type="hidden" id="ranked" value=<%=onlinestudent.getIsRanked()==1%>>
				
					<a href="/grade_srdp/choosefield.jsp" target="main" onclick="return isRanked1()">
						<img src="images/job-msg.png" alt="">
						<span>成绩计算</span>
					</a>
				</div>
				<div class="nav-tit">
					
					<a href="/grade_srdp/findFinalScoreServlet?sid=<%=onlinestudent.getSid()%>" target="main" onclick="return isRanked2()">
						<img src="images/job-msg.png" alt="">
						<span>参评成绩单</span>
					</a>
				</div>
				<div class="nav-tit" id="personal" >
					<a style="cursor: pointer;">
						<img src="images/job-msg.png" alt="">
						<span>保研信息</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/findAllNewsServlet?u=user" target="main">通知公告</a></li>
						
					</ul>
				</div>
				
				<div class="nav-tit">
					<a href="/grade_srdp/changepassword.jsp" target="main">
					<img src="images/modify-password.png" alt="">
					<span>修改密码</span>
					</a>
				</div>
			</div>
		</div>
		<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
		<script>
			$(document).ready(function(){
				$('#personal').on('click',function(){
					$('#personal_child').fadeToggle(300);
				});
				let aLi = $('#personal_child li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
		</script>
<script>
function isRanked1(){
	var x=document.getElementById("ranked").value;
	if (x=="true"){
		alert("您已提交过参评课程，现不可使用此项功能！")
		return false;
	}
	else {
		return true;
	}
	
}
function isRanked2(){
	var x=document.getElementById("ranked").value;
	if (x=="true"){
		return true;
		
	}
	else {
		alert("您已还未提交参评课程，请先进入'成绩计算'功能")
		return false;
	}
	
}
</script>		
	</body>
</html>
