package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import entity.Student;

public class ShowStudentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student stu=new Student();
		StudentDao sd=new StudentDao();
		String type=request.getParameter("type");
		String choice=request.getParameter("choice");
		
		Map<Integer, Student> map=new LinkedHashMap <Integer, Student>();
		if (type.equals("1")){
			if (choice.equals("XinXi")){
				map=sd.scoreRankAsMajor("信息与计算科学");
				request.setAttribute("type", "信息与计算科学");
			}
			else {
				map=sd.scoreRankAsMajor("数学与应用数学");
				request.setAttribute("type", "数学与应用数学");
			}
		}else if(type.equals("2")){
			map=sd.scoreRankAsClass(choice);
			request.setAttribute("type", choice+"班");
		}else {
			map=sd.scoreAllRank();
			request.setAttribute("type", "总");
		}
		request.setAttribute("studentmap",map);
		
		request.getRequestDispatcher("/showstudentRank.jsp").forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
