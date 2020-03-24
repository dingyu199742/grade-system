<%@page import="Util.JudgeUtil"%>
<%@page import="Util.TypeUtil"%>
<%@page import="Util.MajorUtil"%>
<%@page import="Util.SelectedUtil"%>
<%@page import="dao.ScoreDao"%>
<%@page import="dao.CourseDao"%>
<%@page import="entity.Score"%>
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
    	<title>推免成绩计算系统</title>
    	
    	<link rel="stylesheet" href="css/common.css">
    	<link rel="stylesheet" href="css/StudentScrCpt.css">
	</head>
	
	<body>
	<% Student onlinestudent=(Student) session.getAttribute("onlinestudent");%>
	<% Map<String, Score> selectedScores=(Map<String, Score>) session.getAttribute("selectedScores");%>
	<% String selectedField=(String) session.getAttribute("selectedField");%>
	<% Double avegrade=(Double) session.getAttribute("avegrade");%>
	<% Double credit=(Double) session.getAttribute("credit");%>
		<div class="EmInformation container">
			
			<div class="information-content content">
					<% CourseDao cd=new CourseDao(); %>
					<% ScoreDao sd=new ScoreDao(); %>
					
					<% TypeUtil tu=new TypeUtil();%>
					<% MajorUtil mu=new MajorUtil(); %>
  						
  					<%Map<String, Score> completedScores=new LinkedHashMap <String, Score>();%>
  					<form action="/grade_srdp/computeServlet" method="post" target="main">
		        	<!--模块开始-->
		        	
		        	<%for (String ee:ScoreDao.mathCtypesMap.keySet()){ %>
		        		<div class="unit-information">
		        	    <div class="unit">
		        	        <p class="unit-content"><%=tu.getHanzifromType(ee)%>：</p>
		        	    </div>
		        	    
		        	  
		        	    <%if (ee.equals("EPC") && mu.getMajor(selectedField).equals("数学与应用数学")) {%>
   							 <%completedScores=sd.findStuScoreInOneCtype(onlinestudent.getSid(), "EPC1");%>
   							 <div class="unit">
		        	        	<p class="unit-content">四选二：</p>
		        	    	 </div>
		        	    	 <div class="unit-list clearfix">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>课程号</td><td>课程名称</td><td>学分</td><td>成绩</td><td>是否参评</td></tr>
		        				<%for (Score e : completedScores.values()) { %>
		        					<tr>
   							 		<td><%=e.getCcode()%></td>
   							 		<td><%=cd.findOneCourse(e.getCcode()).getCname()%></td>
   							 		<td>&nbsp;&nbsp;<%=cd.findOneCourse(e.getCcode()).getCredit()%></td>
   							 		<td>&nbsp;&nbsp;<%=e.getSgrade()%></td>
   							 		<%if (selectedScores.get(e.getCcode())!=null){%>
   							 			<%if (sd.isQualifiedInMathEPC1(onlinestudent.getSid(), "EPC1", 2)){%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" checked="checked" id="cbox42"/></td>
   							 				<%} else{%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" checked="checked" onclick="return false;"/></td>
   							 			<%}
   							 			
   							 		} else{%>
   							 			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" id="cbox42"/></td>
   							 		<%} %>
   							 		</tr>
		        				<%} %>
		        			</table>	
		            	</div>
		        	</div><br />
   							 <%continue;		
   						 }%>
   						<%completedScores=sd.findStuScoreInOneCtype(onlinestudent.getSid(), ee);%>
		        	    <div class="unit-list clearfix">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>课程号</td><td>课程名称</td><td>学分</td><td>成绩</td><td>是否参评</td></tr>
		        				<%for (Score e : completedScores.values()) { %>
		        					<tr>
   							 		<td><%=e.getCcode()%></td>
   							 		<td><%=cd.findOneCourse(e.getCcode()).getCname()%></td>
   							 		<td>&nbsp;&nbsp;<%=cd.findOneCourse(e.getCcode()).getCredit()%></td>
   							 		<td>&nbsp;&nbsp;<%=e.getSgrade()%></td>
   							 		<%if (selectedScores.get(e.getCcode())!=null){%>
   							 			<%if (ee.equals("ESBC")||ee.equals("EJSC")||ee.equals("EPC")){%>
   							 				<%if (sd.isQualified(onlinestudent.getSid(), ee)){%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" id="cbox" checked="checked" onclick="return judgeMoreESBC('<%=onlinestudent%>')"/></td>
   							 				<%} else{%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" checked="checked" onclick="return false;"/></td>
   							 			<%}
   							 			} else{%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" checked="checked" onclick="return false;"/></td>
   							 			<%}
   							 		}else{%>
   							 			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" id="cbox"/></td>
   							 		<%} %>
   							 		</tr>
		        				<%} %>
		        			</table>	
		            	</div>
		        	</div><br />
		        	<%} %>
		        	
		        	<!--模块结束-->
		        	
		        	<%if (mu.getMajor(selectedField).equals("数学与应用数学")) {%>
   						<%completedScores=sd.findStuScoreInOneCtype(onlinestudent.getSid(), "EPC2");%>
   						<div class="unit-information">
   						
		        	        <div class="unit">
		        	        	<p class="unit-content">其它：</p>
		        	        </div>
		        	        
		        	        <div class="unit-list clearfix">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td>课程号</td><td>课程名称</td><td>学分</td><td>成绩</td><td>是否参评</td></tr>
		        				<%for (Score e : completedScores.values()) { %>
		        					<tr>
   							 		<td><%=e.getCcode()%></td>
   							 		<td><%=cd.findOneCourse(e.getCcode()).getCname()%></td>
   							 		<td>&nbsp;&nbsp;<%=cd.findOneCourse(e.getCcode()).getCredit()%></td>
   							 		<td>&nbsp;&nbsp;<%=e.getSgrade()%></td>
   							 		<%if (selectedScores.get(e.getCcode())!=null){%>
   							 			<%if (sd.isQualifiedInMathEPC2(onlinestudent.getSid())){%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" checked="checked" id="cboxElse"/></td>
   							 				<%} else{%>
   							 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" checked="checked" onclick="return false;"/></td>
   							 			<%}
   							 			
   							 		} else{%>
   							 			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="select" value=<%=e.getCcode()%> type="checkbox" id="cboxElse"/></td>
   							 		<%} %>
   							 		</tr>
		        				<%} %>
		        			</table>	
		            	</div>
   						</div><br />
   						 
   					<%} %>
   					
			        <input style="padding: 1px 8px 2px 8px;margin-left: 320px;margin-bottom: 10px;" type="submit" value="更新" name="Submit2" title="课程，成绩更新，方向不变" />
		        </form>
		        <script src="js/jquery-1.9.1.min.js"></script>
			</div>
		</div>
	</body>
	
</html>
