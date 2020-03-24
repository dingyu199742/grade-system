package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.FieldDao;
import entity.Course;

public class FindOneCourseServlet extends HttpServlet {

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
		String code=(String)request.getParameter("code");
		String op=(String)request.getParameter("op");
		CourseDao cd=new CourseDao();
		Course course=new Course();
		FieldDao fd=new FieldDao();
		course=cd.findOneCourse(code);
		String mathtype=fd.findCtypeInFieldCode(code, "应用数学").getCtype();
		String protype=fd.findCtypeInFieldCode(code, "数理统计").getCtype();
		String Infotype=fd.findCtypeInFieldCode(code, "信息科学").getCtype();
		String Comtype=fd.findCtypeInFieldCode(code, "计算科学").getCtype();
		if (course==null){
			request.setAttribute("msg", "课程不存在！");
			
		}
		else{
			request.setAttribute("course", course);
			request.setAttribute("mathtype", mathtype);
			request.setAttribute("protype", protype);
			request.setAttribute("Infotype", Infotype);
			request.setAttribute("Comtype", Comtype);
			
		}
		if (op.equals("update")){
			request.getRequestDispatcher("/updateCourse.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/showCourse.jsp").forward(request, response);
		}
	}

}
