<%@page import="entity.Score"%>
<%@page import="Util.TypeUtil"%>
<%@page import="dao.ScoreDao"%>
<%@page import="dao.CourseDao"%>
<%@page import="entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/StudentScrCpt.css">

  </head>
  
  <body>
	<% Student student=(Student) request.getAttribute("student");%>
		<div class="EmInformation container">
			
			<div class="information-content content">
					<% CourseDao cd=new CourseDao(); %>
					<% ScoreDao sd=new ScoreDao(); %>
					<% TypeUtil tu=new TypeUtil();%>
					<div class="information-title">
	        			<span>当前位置>参评成绩单</span>
	    			</div>	
  					<%Map<String, Score> completedScores=new LinkedHashMap <String, Score>();%>
  					<div class="unit-information">
		        	    <div class="unit">
		        	        <p class="unit-content">专业:&nbsp;&nbsp;<%=student.getMajor()%>&nbsp;&nbsp;&nbsp;&nbsp;
		        	        &nbsp;&nbsp;专业方向:&nbsp;&nbsp;<%=student.getSfield()%>&nbsp;&nbsp;&nbsp;&nbsp;
		        	        &nbsp;&nbsp;平均学分绩:&nbsp;&nbsp;<%=student.getAvegrade()%>&nbsp;&nbsp;</p>
		        	       
		        	    </div>
  					
		        	<!--模块开始-->
		        	<%for (String ee:ScoreDao.mathCtypesMap.keySet()){ %>
		        		<div class="unit-information">
		        	    <div class="unit">
		        	        <p class="unit-content"><%=tu.getHanzifromType(ee)%>：</p>
		        	    </div>
		        	    
		        	    <%completedScores=sd.findStuScoreSelectedInOneCtype(student.getSid(), ee);%>
		        	    <%if (ee.equals("EPC") && student.getMajor().equals("数学与应用数学")) {%>
   							 <%completedScores=sd.findStuScoreSelectedInOneCtype(student.getSid(), "EPC1");%>
   							 <div class="unit">
		        	        	<p class="unit-content">四选二：</p>
		        	    	 </div>
   							 		
   						<% }%>
		        	    <div class="unit-list clearfix">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>课程号</td><td>课程名称</td><td>学分</td><td>成绩</td></tr>
		        				<%for (Score e : completedScores.values()) { %>
		        					<tr>
   							 		<td><%=e.getCcode()%></td>
   							 		<td><%=cd.findOneCourse(e.getCcode()).getCname()%></td>
   							 		<td>&nbsp;&nbsp;<%=cd.findOneCourse(e.getCcode()).getCredit()%></td>
   							 		<td>&nbsp;&nbsp;<%=e.getSgrade()%></td>
   							 		
   							 		</tr>
		        				<%} %>
		        			</table>	
		            	</div>
		        	</div><br />
		        	<%} %>
		        	
		        	<!--模块结束-->
		        	
		        	<%if (student.getMajor().equals("数学与应用数学")) {%>
   						 <%completedScores=sd.findStuScoreSelectedInOneCtype(student.getSid(), "EPC2");%>
   						<div class="unit-information">
   						
		        	        <div class="unit">
		        	        	<p class="unit-content">其它：</p>
		        	        </div>
		        	        
		        	        <div class="unit-list clearfix">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>课程号</td><td>课程名称</td><td>学分</td><td>成绩</td></tr>
		        				<%for (Score e : completedScores.values()) { %>
		        					<tr>
   							 		<td><%=e.getCcode()%></td>
   							 		<td><%=cd.findOneCourse(e.getCcode()).getCname()%></td>
   							 		<td>&nbsp;&nbsp;<%=cd.findOneCourse(e.getCcode()).getCredit()%></td>
   							 		<td>&nbsp;&nbsp;<%=e.getSgrade()%></td>
   							 		
   							 		</tr>
		        				<%} %>
		        			</table>	
		            	</div>
   						</div><br />
   						 
   					<%} %>
   					
			      
		      
		        <script src="js/jquery-1.9.1.min.js"></script>
			</div>
		</div>
	</body>
</html>
