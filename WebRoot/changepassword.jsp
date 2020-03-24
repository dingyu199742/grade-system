<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/StudentRevise.css">

  </head>
  <%
	String msg =(String) request.getAttribute("msg");
	
  %>
  
  <body onload="checkpass('<%=msg%>')" >
	<div class="container information-content">
    <div class="content">
        <div class="information-title">
            <span>当前位置>修改密码</span>
        </div>
           
        <div class="revise-content clearfix ">
        <form class="form-horizontal"
								action="/grade_srdp/changePasswordServlet" method="post" target="main">
        	<div class="list fr"><label>账号</label> : <input name="idnumber" type="text" placeholder="请输入账号"/></div>
            <div class="list fr"><label>原密码</label> : <input type="password" value="" name="oldpassword" placeholder="请输入原密码"/></div>
            <div class="list fr"><label>新密码</label> : <input type="password" value="" name="passwordsfirst" placeholder="请输入新密码"/></div>
            <div class="list fr "><label>确认密码</label> : <input type="password" value="" name="passwordssecond" placeholder="请确认新密码"/></div>
        </div>
        <div class="list1 "> <input type="submit" value="确认" name="username" onmouseover="this.style.backgroundColor='#1E90FF'"  onmouseout="this.style.backgroundColor='#177ec1'"/></div>

    </div>
   
    </form>
    
</div>
  </body>
  <script>
function checkpass(msg){
	if (msg!="null") {
		alert(msg)
	} 
	
}

</script>
</html>
