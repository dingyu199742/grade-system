<%@page import="entity.Information"%>
<%@page import="Util.HexStrUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
 contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--<link rel="stylesheet" type="text/css" href="css/upload.css"/>-->
    	<title>Title</title>
    	<link rel="stylesheet" href="css/common.css">
    	<link rel="stylesheet" href="css/StudentScrCpt.css">
    	
		<!--<script type="text/javascript">
		  _editor_url = './HTMLArea-3.0-last-20071025';
		  _editor_lang = 'en';
		</script>
		<script type="text/javascript" src="HTMLArea-3.0-last-20071025/htmlarea.js"></script>
		<script type="text/javascript" src="HTMLArea-3.0-last-20071025/dialog.js"></script>
		<script tyle="text/javascript" src="HTMLArea-3.0-last-20071025/lang/en.js"></script>-->
		
		<style type="text/css">
			/*超链接样式*/
			.wenJianXiaZ{
				margin-left: 3%;
				color: black;
			}
			.wenJianXiaZ:hover{
				color: blue;
			}
			.new-unit-content{
			 	height: 30px;
     			border-left:4px solid #0e8384;
    			color: #333;
    			line-height: 30px;
    			padding-left: 0px;
    			text-align: center;
    			border:soild 1px black;
			}
		</style>
		
		
	</head>
	<body>
			
			<%String biaoQian=(String)request.getAttribute("biaoQian");%>
			<%String longText=(String)request.getAttribute("longText");%>
			<%String filePath=(String)request.getAttribute("filePath");%>
			<%String fileName=(String)request.getAttribute("fileName");%>
			<%String time=(String)request.getAttribute("time");%>
			<div class="EmInformation container"">
			<!--<frame src="StudentTop.html" noresize="noresize" scrolling="no" />-->
			<div class="information-content content">
				<!--模块开始-->
				<div class="information-title">
	        			<span>当前位置>公告详情</span>
	    			</div>	
	        	<div class="unit-information">
	        	    <div class="unit" style="margin-bottom: 10px;">
	        	        <p class="new-unit-content"><%=biaoQian%></p>
	        	    </div>
	        	    
	        	    <div style="width: 100%; height: 40em; color: black;padding-left: 2px;">
						<%=longText%>
					</div>
					
			        <p style="color: black;">文件下载：</p>
			        
                    <% //16进制%>
                    <% HexStrUtil hexStrUtil=new HexStrUtil();%>
                    
			    	<a href="/grade_srdp/files/<%=hexStrUtil.str2HexStr(fileName+time)%>" download="<%=fileName%>" class="wenJianXiaZ"><%=fileName%></a>
			    
			    </div><br />
	        	<!--模块结束-->
		        	
		        <script src="js/jquery-1.9.1.min.js"></script>
			</div>
		</div>
	</body>
</html>

