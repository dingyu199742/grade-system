<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="entity.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchStudentTop.jsp' starting page</title>
    
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
    <link rel="stylesheet" href="http://libs.useso.com/js/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
  </head>
  
  <body>
  <div class="EmInformation container"">
   <div class="information-content content" style="margin-left:141px">
   
     <div class="unit-information">
		<div class="unit">
		
	        <p class="unit-content">学生信息查询：</p>
	    </div>
		<form style="margin-left:20px" action="/grade_srdp/searchOneStudentServlet" method="post" target="main">
	       学号：<input type="text" id="searchstr" name="id" class="textbox" size="20">  
	       姓名：<input type="text" id="searchstr" name="name" class="textbox" size="20"> 
	        <input type="submit" value="搜索" onclick="javascript:findIt();" style="padding: 1px 8px 2px 8px;margin-left: 20px;margin-bottom: 10px; margin-right:10px"  onmouseover="this.style.backgroundColor='#1E90FF'"  onmouseout="this.style.backgroundColor='#177ec1'" class="sbttn">

		</form>
    
    </div>
</div>
</div>
<script src="js/jquery-1.9.1.min.js"></script>
<script >
var DOM = (document.getElementById) ? 1 : 0;  
  var NS4 = (document.layers) ? 1 : 0;  
  var IE4 = 0;  
  if (document.all)  
  {  
  IE4 = 1;  
  DOM = 0;  
  }  
  
  var win = window; 
  var n = 0;  
  
  function findIt() {  
  if (document.getElementById("searchstr").value != "")  
  findInPage(document.getElementById("searchstr").value);  
  }  
  
  
  function findInPage(str) {  
  var txt, i, found;  
  
  if (str == "")  
  return false;  
  
  if (DOM)  
  {  
  win.find(str, false, true);  
  return true;  
  }  
  
  if (NS4) {  
  if (!win.find(str))  
  while(win.find(str, false, true))  
  n++;  
  else  
  n++;  
  
  if (n == 0)  
  alert("未找到指定内容.");  
  }  
  
  if (IE4) {  
  txt = win.document.body.createTextRange();  
  
  for (i = 0; i <= n && (found = txt.findText(str)) != false; i++) {  
  txt.moveStart("character", 1);  
  txt.moveEnd("textedit");  
  }  
  
  if (found) {  
  txt.moveStart("character", -1);  
  txt.findText(str);  
  txt.select();  
  txt.scrollIntoView();  
  n++;  
  }  
  else {  
  if (n > 0) {  
  n = 0;  
  findInPage(str);  
  }  
  else  
  alert("未找到指定内容.");  
  }  
  }  
  
  return false;  
  }
</script>
  </body>
  
</html>
