<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8" />

<title>推免成绩计算系统</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<style>
#vcode {
	height: 35px;
	width: 25%;
	font-size: 16pt;
	margin-left: 5%;
	border-radius: 5px;
	background-color: #C0C0C0;
	border: 0;
	font-size: 15px;
	padding-left: 8px;
}
#code {
	height: 35px;
	width: 23%;
	color: #ffffff; /*字体颜色白色*/
	background-color: #C0C0C0;
	font-size: 17pt;
	font-family: "华康娃娃体W5";
	padding: 5px 35px 10px 35px;
	margin-left: 27%;
	cursor: pointer;
	border-radius: 5px; /*设置圆角样式*/
}
</style>
</head>
<body onload="changeImg()">
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<p>推免成绩计算系统</p>
						<form action="/grade_srdp/loginServlet" method="post" onsubmit="return check()">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账号">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="input_outer2">
								
								<input type="text" id="vcode" placeholder="验证码" value="验证码" onfocus="this.value=''" onblur="if(this.value=='')this.value='验证码'"/>
								<span id="code" title="看不清，换一张" readonly="readonly"></span>
							</div>
							<div class="input_outer3">
							<input class="act-but" type="submit" value="登录" onmouseover="this.style.backgroundColor='#00BFFF'"  onmouseout="this.style.backgroundColor='#1E90FF'">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<script type="text/javascript">
	var code;//声明一个变量用于存储生成的验证码  
	document.getElementById("code").onclick = changeImg;
	function changeImg() {
		//alert("换图片");  
		var arrays = new Array('1', '2', '3', '4', '5', '6', '7', '8', '9',
				'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z');
		code = '';//重新初始化验证码  
		//alert(arrays.length);  
		//随机从数组中获取四个元素组成验证码  
		for (var i = 0; i < 4; i++) {
			//随机获取一个数组的下标  
			var r = parseInt(Math.random() * arrays.length);
			code += arrays[r];
			//alert(arrays[r]);  
		}
		//alert(code);  
		document.getElementById('code').innerHTML = code;//将验证码写入指定区域  
	}

	//效验验证码(表单被提交时触发)  
	function check() {
		//获取用户输入的验证码  
		var input_code = document.getElementById('vcode').value;
		//alert(input_code+"----"+code);  
		if (input_code.toLowerCase() == code.toLowerCase()) {
			//验证码正确(表单提交)  
			return true;
		}
		alert("请输入正确的验证码!");
		
		//验证码不正确,表单不允许提交  
		return false;
	}
</script>
	</body>
</html>