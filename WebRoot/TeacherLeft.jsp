<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/StudentLeft.css">
	</head>
	<body>
		<div class="nav" style="width: 260px; position:absolute; overflow-x:hidden; overflow-y:auto; ">
			<div class="nav-list" style="width: 248px; ">
				<div class="nav-tit">
					<a href="/grade_srdp/showStudentServlet?type=3" target="main">
						<img src="images/PubMed-msg.png" alt="">
						<span>年级排名</span>
					</a>
				</div>
				<div class="nav-tit" id="personal">
					<a style="cursor: pointer;">
						<img src="images/PubMed-msg.png" alt="">
						<span>专业排名</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child" style="width: 150px;">
					<ul style="margin-left:15px">
						<li><a href="/grade_srdp/showStudentServlet?choice=XinXi&type=1" target="main">信息与计算科学</a></li>
						<li><a href="/grade_srdp/showStudentServlet?choice=YingShu&type=1" target="main">数学与应用数学</a></li>
					</ul>
				</div>
				<div class="nav-tit" id="personal2">
					<a style="cursor: pointer;">
						<img src="images/PubMed-msg.png" alt="">
						<span>班级排名</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child2" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/showStudentServlet?choice=1&type=2" target="main">数学一班</a></li>
						<li><a href="/grade_srdp/showStudentServlet?choice=2&type=2" target="main">数学二班</a></li>
						<li><a href="/grade_srdp/showStudentServlet?choice=3&type=2" target="main">数学三班</a></li>
					</ul>
				</div>
				<div class="nav-tit" id="personal3" >
					<a style="cursor: pointer;">
						<img src="images/job-msg.png" alt="">
						<span>保研信息</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child3" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/findAllNewsServlet?u=admin" target="main">信息查看</a></li>
						<li><a href="/grade_srdp/XinxiManage.jsp" target="main">上传信息</a></li>
					</ul>
				</div>
				<div class="nav-tit" id="personal4" >
					<a style="cursor: pointer;">
						<img src="images/personal-msg.png" alt="">
						<span>成绩信息</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child4" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/deleteServlet" target="main">预处理</a></li>
						<li><a href="/grade_srdp/XinxiShow.jsp" target="main">信息管理</a></li>
						
					</ul>
				</div>
				<div class="nav-tit" id="personal5" >
					<a style="cursor: pointer;">
						<img src="images/personal-msg.png" alt="">
						<span>课程信息</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child5" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/addCourse.jsp" target="main">添加课程</a></li>
						<li><a href="/grade_srdp/findAllCourseServlet" target="main">课程管理</a></li>
					</ul>
				</div>
				<div class="nav-tit" id="personal6" >
					<a style="cursor: pointer;">
						<img src="images/personal-msg.png" alt="">
						<span>学生信息</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child6" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/findAllStudentServlet" target="main">学生管理</a></li>
						<li><a href="/grade_srdp/addStudent.jsp" target="main">添加学生</a></li>
					</ul>
				</div>
				<div class="nav-tit" id="personal7" >
					<a style="cursor: pointer;">
						<img src="images/job-msg.png" alt="">
						<span>培养方案</span>
					</a>
				</div>
				<div class="personal-list" id="personal_child7" style="width: 130px;">
					<ul>
						<li><a href="/grade_srdp/searchAllFieldServlet" target="main">培养方案查询</a></li>
						<li><a href="/grade_srdp/addStudent.jsp" target="main">修改学分上限</a></li>
					</ul>
				</div>
				<div class="nav-tit">
					<a href="/grade_srdp/changepassword.jsp" target="main">
					<img src="images/modify-password.png" alt="">
					<span>修改密码</span>
					</a>
				</div>
			</div>
		</div>	
		<script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script>
			$(document).ready(function(){
				$('#personal').on('click',function(){
					$('#personal_child').fadeToggle(300);
				});
				let aLi = $('#personal_child li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
			$(document).ready(function(){
				$('#personal2').on('click',function(){
					$('#personal_child2').fadeToggle(300);
				});
				let aLi = $('#personal_child2 li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
			$(document).ready(function(){
				$('#personal3').on('click',function(){
					$('#personal_child3').fadeToggle(300);
				});
				let aLi = $('#personal_child3 li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
			$(document).ready(function(){
				$('#personal4').on('click',function(){
					$('#personal_child4').fadeToggle(300);
				});
				let aLi = $('#personal_child4 li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
			$(document).ready(function(){
				$('#personal5').on('click',function(){
					$('#personal_child5').fadeToggle(300);
				});
				let aLi = $('#personal_child5 li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
			$(document).ready(function(){
				$('#personal6').on('click',function(){
					$('#personal_child6').fadeToggle(300);
				});
				let aLi = $('#personal_child6 li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
			$(document).ready(function(){
				$('#personal7').on('click',function(){
					$('#personal_child7').fadeToggle(300);
				});
				let aLi = $('#personal_child7 li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
		</script>
	</body>
</html>
