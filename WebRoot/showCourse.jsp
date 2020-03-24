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
			
			<div class="information-content content">
				
				<!-- <form> -->
		        	<!--模块开始-->
		        	<div class="unit-information">
		        	    <div class="unit">
		        	       	<p class="unit-content">查看课程信息：</p>
		        	       	<% Course course=(Course)request.getAttribute("course"); %>
		        	       	<% String mathtype=(String)request.getAttribute("mathtype"); %>
		        	       	<% String protype=(String)request.getAttribute("protype"); %>
		        	       	<% String Infotype=(String)request.getAttribute("Infotype"); %>
		        	       	<% String Comtype=(String)request.getAttribute("Comtype"); %>
		        	    </div>
		        	     <div class="revise-content clearfix">
						<%//course.getOldCode().equals("null")?"":course.getOldCode() %>
								<div class="list fr"><label>课程号</label> : <input type="text" name="code" value=<%=course.getCcode()%> readonly="readonly" /></div>
								<div class="list fr"><label>旧课程号</label> : <input type="text" name="oldCode" value=<%course.getOldCode()%> readonly="readonly"/></div>
								<div class="list fr"><label>课程名</label> : <input type="text" name="name" value=<%=course.getCname()%> readonly="readonly" /></div>
								<div class="list fr"><label>学分</label> : <input type="text" name="credit" value=<%=course.getCredit()%> readonly="readonly" /></div>
								
								<div class="list fr">应用数学：<select name="math" disabled="disabled">
									<option value="PBC" <%=mathtype.equals("PBC")?"selected":""%>>公共基础课</option>
									<option value="RSBC" <%=mathtype.equals("RSBC")?"selected":""%>>学科基础课（必）</option>
									<option value="ESBC" <%=mathtype.equals("ESBC")?"selected":""%>>学科基础课（选）</option>
									<option value="RPC" <%=mathtype.equals("RPC")?"selected":""%>>专业知识课（必）</option>
									<option value="EPC1" <%=mathtype.equals("EPC1")?"selected":""%>>四选二</option>
									<option value="EPC2" <%=mathtype.equals("EPC2")?"selected":""%>>专业知识其他</option>
									<option value="RJSC" <%=mathtype.equals("RJSC")?"selected":""%>>工作技能课（必）</option>
									<option value="EJSC" <%=mathtype.equals("EJSC")?"selected":""%>>工作技能课（选）</option>	
								</select></div>
								<div class="list fr">数理统计：<select name="probability" disabled="disabled">
									<option value="PBC" <%=protype.equals("PBC")?"selected":""%>>公共基础课</option>
									<option value="RSBC" <%=protype.equals("RSBC")?"selected":""%>>学科基础课（必）</option>
									<option value="ESBC" <%=protype.equals("ESBC")?"selected":""%>>学科基础课（选）</option>
									<option value="RPC" <%=protype.equals("RPC")?"selected":""%>>专业知识课（必）</option>
									<option value="EPC1" <%=protype.equals("EPC1")?"selected":""%>>四选二</option>
									<option value="EPC2" <%=protype.equals("EPC2")?"selected":""%>>专业知识其他</option>
									<option value="RJSC" <%=protype.equals("RJSC")?"selected":""%>>工作技能课（必）</option>
									<option value="EJSC" <%=protype.equals("EJSC")?"selected":""%>>工作技能课（选）</option>	
								</select></div>
								<div class="list fr">计算科学：<select name="computing" disabled="disabled">
									<option value="PBC" <%=Comtype.equals("PBC")?"selected":""%>>公共基础课</option>
									<option value="RSBC" <%=Comtype.equals("RSBC")?"selected":""%>>学科基础课（必）</option>
									<option value="RPC" <%=Comtype.equals("RPC")?"selected":""%>>专业知识课（必）</option>
									<option value="EPC" <%=Comtype.equals("EPC")?"selected":""%>>专业知识课（选）</option>
									<option value="RJSC" <%=Comtype.equals("RJSC")?"selected":""%>>工作技能课（必）</option>
									<option value="EJSC" <%=Comtype.equals("EJSC")?"selected":""%>>工作技能课（选）</option>	
								</select></div>
								<div class="list fr">信息科学：<select name="Info" disabled="disabled">
									<option value="PBC" <%=Infotype.equals("PBC")?"selected":""%>>公共基础课</option>
									<option value="RSBC" <%=Infotype.equals("RSBC")?"selected":""%>>学科基础课（必）</option>
									<option value="RPC" <%=Infotype.equals("RPC")?"selected":""%>>专业知识课（必）</option>
									<option value="EPC" <%=Infotype.equals("EPC")?"selected":""%>>专业知识课（选）</option>
									<option value="RJSC" <%=Infotype.equals("RJSC")?"selected":""%>>工作技能课（必）</option>
									<option value="EJSC" <%=Infotype.equals("EJSC")?"selected":""%>>工作技能课（选）</option>	
								</select></div>
						</div>		
						
						
						
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
