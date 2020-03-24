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
    <style>
    .container .information-content{
    font-size: 17px;
   
    height:700px;
    

}
.container .content .information-title{
    width: 100%;
    font-size: 16px;
    height: 60px;
    line-height: 75px;
    margin-left:30px;
    position: relative;
    color:#666;
}
.container .content .information-title .fac-information{
    position: absolute;
    left:600px ;
    top:20px;
}
.container .content .revise-content{
    width:244px;
    margin-left: 140px;
    margin-top: 60px;
    margin-bottom: 100px;

}
.container .content .revise-content .list{
  
   margin-bottom: 100px;
}

.container .content .list1{
     width: 400px;
     height: 30px;
     border-radius: 6px;
     margin-left: 100px;
     padding-bottom:100px;
} 
a{
display: inline-block;
margin-right: 70px;

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
  <div class="container information-content">
    <div class="content">
        <div class="information-title">
            <span>当前位置>初始化专业方向</span>
        </div>
             
        <div class="revise-content clearfix ">
           <div class="list1"> 
           		<a href="/grade_srdp/initialComputingServlet?field=a" target="main" >信息科学</a>
				<a href="/grade_srdp/initialComputingServlet?field=b" target="main" >计算科学</a></div>
		   <div class="list1">                   
			 	<a href="/grade_srdp/initialComputingServlet?field=c" target="main" >应用数学</a>
			 	<a href="/grade_srdp/initialComputingServlet?field=d" target="main" >数理统计</a>
		   </div>
			
        </div>
       
    </div>
   
   </div>
  </body>
</html>