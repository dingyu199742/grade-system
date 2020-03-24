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

  </head>
   <%
	String msg =(String) request.getAttribute("msg");
	
  %>
  
  <body onload="checkpass('<%=msg%>')" >
  </body>
  <script>
function checkpass(msg){
	if (msg!="null") {
		alert(msg)
	} 
	
}

</script>
</html>
