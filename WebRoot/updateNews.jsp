<%@page import="Util.DateUtil"%>
<%@page import="entity.Information"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/upload.css"/>
    	<title>Title</title>
    	<link rel="stylesheet" href="css/common.css">
    	<link rel="stylesheet" href="css/StudentScrCpt.css">
    	
    	<!-- 文件上传 -->
		<script type="text/javascript">
		  _editor_url = './HTMLArea-3.0-last-20071025';
		  _editor_lang = 'en';
		</script>
		<script type="text/javascript" src="HTMLArea-3.0-last-20071025/htmlarea.js"></script>
		<script type="text/javascript" src="HTMLArea-3.0-last-20071025/dialog.js"></script>
		<script tyle="text/javascript" src="HTMLArea-3.0-last-20071025/lang/en.js"></script>
	</head>
	<body>
		<div class="EmInformation container"">
			<!--<frame src="StudentTop.html" noresize="noresize" scrolling="no" />-->
			<div class="information-content content">
				<!--模块开始-->
	        	<div class="unit-information">
	        	    <div class="unit" style="margin-bottom: 10px;">
	        	        <p class="unit-content">修改通知公告：</p>
	        	    </div>
	        	    <%Information news=(Information)request.getAttribute("news");%>
	        	    <form onsubmit="return false;" action="${pageContext.request.contextPath}/uploadNewsServlet" method="post" enctype="multipart/form-data">
	        	    	<input type="text" placeholder="请输入标题" value=<%=news.getBiaoqian()%>style="width: 50%;margin-left: 25%;height: 30px;margin-bottom: 10px;font-size:medium ;" name="biaoQian"/>
						<textarea id="TA" style="width: 100%; height: 40em;" name="longText">
							<%=news.getLongText() %>
						</textarea>
						
				        文件名：<input type="text" value=<%=news.getFileName()%> name="fileName"readonly="readonly" name="upload" style="width: 60%; margin-top: 7px;margin-left: 12%;"/>
				        <input type="submit" name="" value="确认修改" style="width: 120px;margin-top: 12px;"/>
				       	<%DateUtil du=new DateUtil();%>
				       	上传时间：<input type="hidden" value=<%=news.getTime()%> name="time">
				       	<input type="hidden" value="D:\Tomact\apache-tomcat-8.5.31\webapps\grade_srdp\grade_srdp\files" name="path">
					</form>
	        	</div><br />
	        	<!--模块结束-->
		        	
		        <script src="js/jquery-1.9.1.min.js"></script>
			</div>
		</div>
	</body>
</html>

