package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;

public class SearchOneCourseServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
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

		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("ccode");
		String name=request.getParameter("cname");
		CourseDao cd=new CourseDao();
		
//		student=sd.findOneStudent(id);
		Map<String,Course> map=new LinkedHashMap<String,Course>();
		map=cd.findCourseByNameAndCode(name, code);
//		if (student==null){
//			request.setAttribute("msg", "该学生不存在！");
//			
//		}
//		else{
//			request.setAttribute("student", student);
//			
//		}
		HttpSession session=request.getSession();
		session.setAttribute("course",map);
		request.getRequestDispatcher("/courseManageAll.jsp").forward(request, response);
	}

}
