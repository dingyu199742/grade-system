<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Field"%>
<%@ page import="entity.Course"%>
<%@ page import="dao.CourseDao"%>
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
		        	<div class="unit-information">
		        	    <div class="unit">
		        	    	
		        	       	<p class="unit-content">课程列表：</p>
		        	    </div>
		        	    <% Map<String,Field> map= (Map<String, Field>) session.getAttribute("field");
						%>
						<div class="table-responsive table2excel" style="margin-left:20px">
		            		<table border="1" cellspacing="0" width="720px">
		        				<tr><td align="center" style="width: 150px;">课程号</td><td align="center">课程名</td><td align="center">学分</td>
		        				<%
										for (Map.Entry<String,Field> entry:map.entrySet()) {
								%>
								<%
									CourseDao cd=new CourseDao();
									
								 %>
		        				<tr>
										<td align="center"><%=entry.getValue().getCcode()%></td>
										<td align="center"><%=cd.findOneCourse(entry.getValue().getCcode()).getCname()%></td>
										<td align="center"><%=cd.findOneCourse(entry.getValue().getCcode()).getCredit()%></td>	
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
		function ajaxLoadingShow(){  
    $.ajax({  
        beforeSend:function(){  
            var xval=getBusyOverlay('viewport',{color:'gray', opacity:0.5, text:'viewport: loading...', style:'text-shadow: 0 0 3px black;font-weight:bold;font-size:16px;color:#FF00CC'},{color:'#ff0', size:100, type:'o'});  
            if(xval) {  
                xval.settext("正在处理中，请稍后......");  
                $("#viewport").attr("style","text-shadow: 0 0 3px black;font-weight:bold;font-size:16px;color:#FF00CC");  
                $("#viewport").show();  
            }  
        }  
    });  
}  
/*  
 * 取消圆圈加载进度条  
 */  
function ajaxLoadingHidden(){  
    $("#viewport").removeAttr("style");  
    $("#viewport").hide();  
}
		</script>
		<!--<script src="js/jquery-1.9.1.min.js"></script>-->
  </body>
</html>
