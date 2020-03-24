package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import entity.Student;

public class SearchOneStudentServlet extends HttpServlet {

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
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		StudentDao sd=new StudentDao();
		Student student=new Student();
//		student=sd.findOneStudent(id);
		Map<String,Student> map=new LinkedHashMap<String,Student>();
		map=sd.findStudentByNameAndID(name, id);
//		if (student==null){
//			request.setAttribute("msg", "该学生不存在！");
//			
//		}
//		else{
//			request.setAttribute("student", student);
//			
//		}
		HttpSession session=request.getSession();
		session.setAttribute("student",map);
		
		request.getRequestDispatcher("/studentManageAll.jsp").forward(request, response);
		
		//request.getRequestDispatcher("/studentManageAll.jsp").forward(request, response);
		//System.out.println("3");
	}

}