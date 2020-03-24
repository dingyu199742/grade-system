<%@page import="Util.RankUtil"%>
<%@page import="Util.MajorUtil"%>
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
    <base href="<%=basePath%>">
    
    <title>推免成绩计算系统</title>
    
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/StudentScrCpt.css">
	<style>
			#tips{
			position: absolute;
			display: none;
		}
			p{
			width:400px;
			border:black 1px solid;
		}
			a:LINK,a:VISITED {
        color:#A62020;
        padding:4px 10px 4px 10px;
        background-color:#DDD;
        text-decoration: none;
        border-top: 1px solid #EEEEEE;
        border-left: 1px solid #EEEEEE;
        border-bottom: 1px solid #717171;
        border-right: 1px solid #717171;
        border-radius: 6px;
    }

    a:HOVER {
        color: #821818;
        padding: 5px 8px 3px 12px;
        background-color: #CCC;
        border-top: 1px solid #717171;
        border-left: 1px solid #717171;
        border-bottom: 1px solid #EEEEEE;
        border-right: 1px solid #EEEEEE;
        border-radius: 6px;
    }
	</style>
  </head>
  
<body>
<% Student onlinestudent=(Student) session.getAttribute("onlinestudent");%>
<% Map<String, Score> selectedScores=(Map<String, Score>) session.getAttribute("selectedScores");%>
<% String selectedField=(String) session.getAttribute("selectedField");%>
<% Double avegrade=(Double) session.getAttribute("avegrade");%>
<% Double credit=(Double) session.getAttribute("credit");%>
<% RankUtil ru=new RankUtil(); %>
<div class="EmInformation container"">
	
    <div class="information-content content">
		<div class="information-title">
	        <span>当前位置>成绩计算</span>
	    </div>
		<form action="/grade_srdp/initialComputingServlet" method="post" target="main">
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;专业方向：
			<select name="field">
				<option value="应用数学" <%=selectedField.equals("应用数学")?"selected":""%>>应用数学</option>
				<option value="数理统计" <%=selectedField.equals("数理统计")?"selected":""%>>数理统计</option>
				<option value="计算科学" <%=selectedField.equals("计算科学")?"selected":""%>>计算科学</option>
				<option value="信息科学" <%=selectedField.equals("信息科学")?"selected":""%>>信息科学</option>
			</select>
			
			<input style="padding: 1px 8px 2px 8px;margin-left: 20px;margin-bottom: 10px; margin-right:10px" 
			type="submit" value="更新" name="Submit1" title="下面将显示系统 根据您已选择的专业方向，成绩由高到低所确定得参评课程，并且更新成绩"  onmouseout="vanishtips()" onmouseover="displaytips()" onmousemove="displaytips()" />
			<!-- <a href="/grade_srdp/initialComputingServlet?field=" title="下面将显示系统 根据您的专业方向所确定得最优参评课程，并且更新成绩" target="main">重置</a> -->
			<!-- selectedField -->
			<input type="hidden" id="credit" value=<%=ru.isRanked(onlinestudent.getSid(),credit)%>>
			
			
			平均学分绩：<input name="avegrade"type="text" readonly="readonly" style=" height: 29px; width: 90px; font-size:16px;" value=<%=avegrade%>>     
			<a href="/grade_srdp/saveSelectedInfoServlet" style=" display: inline-block; width:60px; margin-left: 15px; text-align: center;" target="main" title="提交后不可更改，请认真检查参评的课程及专业方向" onclick="return judgeCredit('<%=credit%>')"  >提交</a> 
			
				
			
			
			
		</form>
    
    </div>
</div>
<script src="js/jquery-1.9.1.min.js"></script>
<!-- 总学分限制js -->
<script>
function judgeCredit(credit){
	var x=document.getElementById("credit").value;
	if (x=="true"){
		var msg = "您已达到学分要求，是否提交？";
	   	if (confirm(msg)==true){
			return true;
		}else{
			return false;
	}
	}
	else {
		alert("您的参评学分为"+credit+", 未达到要求, 不可参评！")
		return false;
	}
	
}
function displaytips() {
	var tip = document.getElementById("tips"); 
	var x = event.clientX + document.body.scrollLeft + 20;	
	var y = event.clientY + document.body.scrollTop - 5;  
	tip.style.left = x + "px";		
	tip.style.top = y + "px";			
	tip.style.display = "block";		
}
function vanishtips(){
	var tip = document.getElementById("tips");
	tip.style.display = "none";
		}


</script>
</body>
</html>
