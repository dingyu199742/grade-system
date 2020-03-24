<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findOneStudentbody.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/delete.js"></script>
	<link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/StudentScrCpt.css">
	<link rel="stylesheet" href="http://libs.useso.com/js/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
  </head>
  
  <body>
    <div class="EmInformation container" style="margin-left:-13px">
			
			<div class="information-content content">
				
				<!-- <form> -->
		        	<!--模块开始-->
		        	<div class="unit-information" >
		        	    <div class="unit">
		        	    	
		        	       	<p class="unit-content">学生列表：</p>
		        	    </div>
		        	    <% Map<String, Student> map= (Map<String, Student>) session.getAttribute("student");%>
		        	    <% //Map<String, Student> map= (Map<String, Student>) request.getAttribute("student");%>
						<div class="table-responsive table2excel" >
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td align="center" style="width: 150px;">学号</td><td align="center">姓名</td><td align="center">班级</td><td align="center">专业</td><td align="center">方向</td><td align="center">成绩</td><td align="center" style="width: 70px; ">是否提交</td><td align="center">密码</td><td colspan="3" style="text-align: center;">操作</td>
		        				<%
										for (Map.Entry<String,Student> entry:map.entrySet()) {
								%>
		        				<tr>
										<td align="center"><%=entry.getKey()%></td>
										<td align="center"><%=entry.getValue().getSname()%></td>
										<td align="center"><%=entry.getValue().getSclass()==null?"":entry.getValue().getSclass()%></td>
										<td align="center"><%=entry.getValue().getMajor()==null?"":entry.getValue().getMajor()%></td>
										<td align="center"><%=entry.getValue().getSfield()==null?"":entry.getValue().getSfield()%></td>
										<td align="center"><%=entry.getValue().getAvegrade()==0.0?"":entry.getValue().getAvegrade()%></td>
										<td align="center"><%=entry.getValue().getIsRanked()==0?"否":"是"%></td>
										<td align="center"><%=entry.getValue().getPassword()%></td>
										<td><a href="/grade_srdp/findOneStudentServlet?id=<%=entry.getKey()%>" target="main">修改</a></td>
										<td><a href="/grade_srdp/refreshStudentServlet?id=<%=entry.getKey()%>" onclick="return refresh()" target="main">重置</a></td>
   										<td><a href="/grade_srdp/deleteStudentServlet?id=<%=entry.getKey()%>" onclick="return del()" target="main">删除</a></td>
										
										
										
								</tr>
								<%
									}
								%>
 
		        			</table>
		            	</div>
		        	</div><br />
		        	<!--模块结束-->
		        	
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
		function refresh() {
			var msg = "确定要重置吗?";
			if (confirm(msg)==true){
				return true;
			}else{
				return false;
			}
		}
		</script>
		<!--<script src="js/jquery-1.9.1.min.js"></script>-->
  </body>
</html>
