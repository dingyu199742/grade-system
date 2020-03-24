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
			frame{
				height: 2000px;
			}
		</style>
	</head>
	<frameset frameborder="0" rows="70,*">
		<frame src="/grade_srdp/top.jsp" noresize="noresize" scrolling="no" />
		<frameset frameborder="0" cols="248,*">
			<frame src="/grade_srdp/left.jsp" noresize="noresize" scrolling="no"  />
			<frame noresize="noresize" scrolling="auto" name="main" />
			<!-- <frame noresize="noresize" scrolling="no" name="main"  src="首页.html"/> -->
		</frameset>
	</frameset>
</html>