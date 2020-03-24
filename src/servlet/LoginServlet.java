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

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student stu=new Student();
		stu.setSid(username);
		stu.setPassword(password);
		StudentDao sd=new StudentDao();
		stu=sd.loginStudent(stu);
		if (stu == null) {
			request.setAttribute("msg", "登录失败,请重新输入");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msg", "登录成功");
			HttpSession session = request.getSession();
			// session.setAttribute("currentuser", user);//设置令牌
			session.setAttribute("onlinestudent", stu);// 设置令牌
			if(stu.getSid().equals("20160001078")){
			request.getRequestDispatcher("/admitshow.jsp").forward(request,
					response);
			}else{
				request.getRequestDispatcher("/homepage.jsp").forward(request,
						response);
			}
		}
	
	}

}
