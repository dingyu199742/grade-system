<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentManageAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/StudentScrCpt.css">
  </head>
  
  <frameset frameborder="0" rows="145,*">
	<frame src="/grade_srdp/searchCourseTop.jsp" noresize="noresize" scrolling="no"/>
	<frame src="/grade_srdp/findOneCoursebody.jsp" noresize="noresize" scrolling="auto"/>
	<!-- <frameset frameborder="0" cols="2500,*"> -->
	
  </frameset>
</html>