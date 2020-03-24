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
    	<link rel="stylesheet" href="css/common.css">
    	<link rel="stylesheet" href="css/StudentScrCpt.css">
		<link rel="stylesheet" href="http://libs.useso.com/js/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	</head>
	<body>
		<div class="EmInformation container"">
			<!--<frame src="StudentTop.jsp" noresize="noresize" scrolling="no" />-->
			<div class="information-content content">
				
				<!-- <form> -->
		        	<!--模块开始-->
		        	<div class="unit-information">
		        	    <div class="unit">
		        	    	<%String type=(String)request.getAttribute("type"); %>
		        	       	<p class="unit-content"><%=type%>排名：</p>
		        	    </div>
		        	    <%Map<Integer, Student> map = (Map<Integer, Student>) request.getAttribute("studentmap");
						StudentDao sd=new StudentDao();
						%>
						<div class="table-responsive table2excel" style="margin-left:20px">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>排名</td><td>学号</td><td>姓名</td><td>平均学分绩</td><td>班级</td><td>专业</td><td>方向</td></tr>
		        				<%
										for (Map.Entry<Integer,Student> entry:map.entrySet()) {
								%>
		        				<tr>
										<td><%=entry.getKey()%></td>
										<td><%=entry.getValue().getSid()%></td>
										<td><a href="/grade_srdp/findFinalScoreServlet?sid=<%=entry.getValue().getSid()%>"><%=entry.getValue().getSname()%></a></td>
										<td><%=entry.getValue().getAvegrade()%></td>
										<td><%=entry.getValue().getSclass()%></td>
										<td><%=entry.getValue().getMajor()%></td>
										<td><%=entry.getValue().getSfield()%></td>
										
										
										
								</tr>
								<%
									}
								%>
 
		        			</table>
		            	</div>
		        	</div><br />
		        	<!--模块结束-->
		        	<button id="btn" class="btn btn-primary" style="padding: 1px 8px 2px 8px;margin-left: 320px;margin-bottom: 10px;">导出至Excel</button>
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
