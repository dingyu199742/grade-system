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
	<body onload="HTMLArea.replace('TA')">
		<div class="EmInformation container"">
			<!--<frame src="StudentTop.html" noresize="noresize" scrolling="no" />-->
			<div class="information-content content">
				<!--模块开始-->
	        	<div class="unit-information">
	        	    <div class="unit" style="margin-bottom: 10px;">
	        	        <p class="unit-content">上传通知公告：</p>
	        	    </div>
	        	    
	        	    <form onsubmit="return false;" action="${pageContext.request.contextPath}/uploadServlet" method="post" enctype="multipart/form-data">
	        	    	<input type="text" placeholder="请输入标题" style="width: 50%;margin-left: 25%;height: 30px;margin-bottom: 10px;font-size:medium ;" name="biaoQian"/>
						<textarea id="TA" style="width: 100%; height: 40em;" name="longText">
							<p>Here is some sample text in textarea that's been transformed with <font
							color="#0000CC"><b>HTMLArea</b></font>.<br />
							You can make things <b>bold</b>, <i>italic</i>, <u>underline</u>.  You can change the
							<font size="3">size</font> and <b><font color="#0000CC">c</font><font color="#00CC00">o</font><font color="#00CCCC">l</font><font color="#CC0000">o</font><font color="#CC00CC">r</font><font color="#CCCC00">s</font><font color="#CCCCCC">!</font></b>
							And lots more...</p>
							<p align="center"><font size="4" color="#ff0000"><b><u>Try HTMLArea
							today!</u></b></font><br /></p>
						</textarea>
						
				        <input type="file" name="upload" style="width: 60%; margin-top: 7px;margin-left: 12%;"/>
				        <input type="submit" name="" value="上传文本和文件" style="width: 120px;margin-top: 12px;"/>
				        <p style="color: red;margin-left: 12%;">（文件名中请勿包含 @*/+ 支持Google、360等浏览器，不兼容Edge浏览器）</p>
					</form>
	        	</div><br />
	        	<!--模块结束-->
		        	
		        <script src="js/jquery-1.9.1.min.js"></script>
			</div>
		</div>
	</body>
</html>

