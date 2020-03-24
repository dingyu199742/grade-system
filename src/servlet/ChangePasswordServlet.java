package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import entity.Student;

public class ChangePasswordServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session1=request.getSession();
		Student onlinestudent=(Student)session1.getAttribute("onlinestudent");
		String idnumber=request.getParameter("idnumber");
		String oldpassword = request.getParameter("oldpassword");
		//cardnumber.trim();
		String newpasswords1 = request.getParameter("passwordsfirst");
		String newpasswords2 = request.getParameter("passwordssecond");
		//int oldpassword = Integer.valueOf(cardnumber);
		StudentDao sd=new StudentDao();
		Student stu=new Student();
		//user.setIDcard_number(idcard_number);
		if (idnumber.equals(onlinestudent.getSid())){
			if (oldpassword.equals(onlinestudent.getPassword())){
				if (newpasswords1.equals(newpasswords2)) {
					//user.setPasswords(newpasswords2);
						if (sd.updateStudentPassword(idnumber, newpasswords2)) {
							request.setAttribute("msg", "密码修改成功");
							request.getRequestDispatcher("/homepage2.jsp").forward(request,
									response);
						} else {
							request.setAttribute("msg", "修改失败,请重新输入");
							request.getRequestDispatcher("/changepassword.jsp")
									.forward(request, response);
						}
					}
				else {
					request.setAttribute("msg", "两次输入不一样");
					request.getRequestDispatcher("/changepassword.jsp").forward(
							request, response);
				}
			}else {
				
				request.setAttribute("msg", "旧密码输入错误！");
				request.getRequestDispatcher("/changepassword.jsp").forward(
						request, response);
			}
			

		
		}else{
			request.setAttribute("msg", "账号输入错误！");
			request.getRequestDispatcher("/changepassword.jsp").forward(
					request, response);
		}
		
	}
}

