<%@page import="entity.Course"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCourse.jsp' starting page</title>
    
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/StudentRevise.css">
  </head>
  
  <body>
		<div class="EmInformation container"">
			
			<div class="information-content content" style="height:auto">
				
				<!-- <form> -->
		        	<!--模块开始-->
		        	<div class="unit-information">
		        	    <div class="unit">
		        	    	
		        	       	<p class="unit-content">添加课程：</p> 
		        	       	
		        	    </div>
		        	     <div class="revise-content clearfix">
						<form class="form-horizontal" action="/grade_srdp/addCourseServlet" method="post">
								<div class="list fr"><label>课程号</label> : <input type="text" name="code" required="required" /></div>
								<div class="list fr"><label>旧课程号</label> : <input type="text" name="oldCode" /></div>
								<div class="list fr"><label>课程名</label> : <input type="text" name="name" required="required" /></div>
								<div class="list fr"><label>学分</label> : <input type="text" name="credit" pattern="^[0-9]+(.[0-9]{1})?$" required="required" /></div>
								<div class="list fr">应用数学：<select name="math">
									<option value="PBC">公共基础课</option>
									<option value="RSBC">学科基础课（必）</option>
									<option value="ESBC">学科基础课（选）</option>
									<option value="RPC">专业知识课（必）</option>
									<option value="EPC1">四选二</option>
									<option value="EPC2">专业知识其他</option>
									<option value="RJSC">工作技能课（必）</option>
									<option value="EJSC">工作技能课（选）</option>	
								</select></div>
								<div class="list fr">数理统计：<select name="probability">
									<option value="PBC">公共基础课</option>
									<option value="RSBC">学科基础课（必）</option>
									<option value="ESBC">学科基础课（选）</option>
									<option value="RPC">专业知识课（必）</option>
									<option value="EPC1">四选二</option>
									<option value="EPC2">专业知识其他</option>
									<option value="RJSC">工作技能课（必）</option>
									<option value="EJSC">工作技能课（选）</option>	
								</select></div>
								<div class="list fr">计算科学：<select name="computing">
									<option value="PBC">公共基础课</option>
									<option value="RSBC">学科基础课（必）</option>
									<option value="RPC">专业知识课（必）</option>
									<option value="EPC">专业知识课（选）</option>
									<option value="RJSC">工作技能课（必）</option>
									<option value="EJSC">工作技能课（选）</option>	
								</select></div>
								<div class="list fr">信息科学：<select name="Info">
									<option value="PBC">公共基础课</option>
									<option value="RSBC">学科基础课（必）</option>
									<option value="RPC">专业知识课（必）</option>
									<option value="EPC">专业知识课（选）</option>
									<option value="RJSC">工作技能课（必）</option>
									<option value="EJSC">工作技能课（选）</option>	
								</select></div>
						</div>		
						 <div class="list1 "><input type="submit" value="添加" onmouseover="this.style.backgroundColor='#1E90FF'"  onmouseout="this.style.backgroundColor='#177ec1'"/></div>
						
						</form>
						
		        	</div>
		        	<br />
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
		</script>
		<!--<script src="js/jquery-1.9.1.min.js"></script>-->
	</body>
</html>
