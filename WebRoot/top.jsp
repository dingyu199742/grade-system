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
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			.bx{
				height: 80px;
				width: 100%;
				background: #4390b9;
			}
			.bx .container{
				margin: 0px 80px 0px 40px;
				overflow: hidden;
			}
			.bx .container .left{
				width: 201px;
				height: 43px;
				padding-top: 19px;
				color: #FFFFFF;
				font-size: 24px;
				float: left;
			}
			.bx .container .right{
				overflow: hidden;
				width: 230px;
				padding-top: 19px;
				float: right;
			}
			.bx .container .right span{
				font-size: 16px;
				color: #fff;
			}
			.bx .container .right .l{
				float: left;
				padding-top: 6px;
			}
			.bx .container .right .r{
				padding-top: 6px;
				float: right;
			}
		</style>
	</head>
	<body style="height: 180px; ">
	<% Student onlinestudent=(Student) session.getAttribute("onlinestudent");%>
		<div class="bx" >
			<div class="container" style="height: 176px; ">
				<h2 class="left">推免成绩计算系统</h2>
				<div class="right">
					<span class="l">你好, <%=onlinestudent.getSname()%> !</span>
					<span class="r">
						<a href="/grade_srdp/login.jsp" target="_parent" style="color: white;">退出登录</a>
					</span>
				</div>
			</div>
		</div>
	</body>
</html>
