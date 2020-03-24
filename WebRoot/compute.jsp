<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>推免成绩计算系统</title>
    
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/StudentScrCpt.css">
	<script>
	 	
		function checkcredit(msg){
			if (msg!="null") {
				alert(msg)
			} 
		
		}
		
	</script>
  </head>
  	<%
	String msg =(String) request.getAttribute("msg");

  	%>

  <frameset  frameborder="0" rows="145,*">
	<frame onload="checkcredit('<%=msg%>')" src="/grade_srdp/computetop.jsp" noresize="noresize" scrolling="no"/>
	<frame src="/grade_srdp/computebody.jsp" noresize="noresize" scrolling="auto"/>
	<!-- <frameset frameborder="0" cols="2500,*"> -->
	
  </frameset>
  <!-- </frameset> -->
   
</html>
