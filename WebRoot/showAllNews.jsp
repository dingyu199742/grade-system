<%@page import="entity.Information"%>
<%@page import="dao.StudentDao"%>
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
    	<title>Title</title>
    	<script src="js/delete.js"></script>
		<link rel="stylesheet" href="css/common.css">
    	<link rel="stylesheet" href="css/StudentScrCpt.css">
		<link rel="stylesheet" href="http://libs.useso.com/js/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	</head>
	<body>
		<div class="EmInformation container"">
			
			<div class="information-content content">
				
				<!-- <form> -->
		        	<!--模块开始-->
		        	<div class="unit-information">
		        	    <div class="unit">
		        	    	
		        	       	<p class="unit-content">通知公告：</p>
		        	    </div>
		        	    <%Map<String, Information> map = (Map<String, Information>) request.getAttribute("news");%>
						<div class="table-responsive table2excel" style="margin-left:20px">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>标题</td><td>发布时间</td><td>操作</td></tr>
		        				<%
										for (Map.Entry<String, Information> entry:map.entrySet()) {
								%>
		        				<tr>
										<td><a href="/grade_srdp/findOneNewsServlet?fileName=<%=entry.getValue().getFileName()%>&time=<%=entry.getValue().getTime()%>&op=find"><%=entry.getValue().getBiaoqian()%></a></td>
										<td><%=entry.getValue().getTime()%></td>
									
   										<td><a href="/grade_srdp/deleteNewsServlet?fileName=<%=entry.getValue().getFileName()%>&time=<%=entry.getValue().getTime()%>" onclick="return del()">删除</a></td>
	
								</tr>
								<%
									}
								%>
 
		        			</table>
		            	</div>
		        	</div><br />
		        	<!--模块结束-->
		        	
			        <!-- <input style="padding: 1px 8px 2px 8px;margin-left: 320px;margin-bottom: 10px;"id="btn" class="btn btn-primary" type="submit" value="导出至Excel" name="Submit2"/> -->
		        <!-- </form> -->
		       
			</div>
		</div>
		<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="dist/jquery.table2excel.js"></script>
		<script>
			$(function() {
				$("#btn").click(function(){
				$(".table2excel").table2excel({
				exclude: ".noExl",
				name: "Excel Document Name",
				filename: "myFileName",
				exclude_img: true,
				exclude_links: true,
				exclude_inputs: true
				});
			});
						
		});
		</script>
		<!--<script src="js/jquery-1.9.1.min.js"></script>-->
	</body>
</html>
