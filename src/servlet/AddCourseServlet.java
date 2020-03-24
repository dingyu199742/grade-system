package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.FieldDao;
import entity.Course;
import entity.Field;

public class AddCourseServlet extends HttpServlet {

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
		String code=(String) request.getParameter("code");
		String name=(String) request.getParameter("name");
		double credit=Double.valueOf(request.getParameter("credit"));
		String oldCode=(String) request.getParameter("oldCode");
		String mathtype=(String) request.getParameter("math");
		String protype=(String) request.getParameter("probability");
		String Infotype=(String) request.getParameter("Info");
		String Comtype=(String) request.getParameter("computing");
		CourseDao cd=new CourseDao();
		if (cd.findOneCourse(code)!=null){
			request.setAttribute("msg", "此课程已存在！");
		}
		else{
			request.setAttribute("msg", "添加成功！");
			Course course=new Course(code, name, credit, oldCode);
			cd.addCourse(course);
			FieldDao fd=new FieldDao();
			Field mathfield=new Field("应用数学", code, mathtype);
			Field profield=new Field("数理统计", code, protype);
			Field comfield=new Field("计算科学", code, Comtype);
			Field infofield=new Field("信息科学", code, Infotype);
			
			fd.addCtypeInFieldCode(mathfield);
			fd.addCtypeInFieldCode(profield);
			fd.addCtypeInFieldCode(comfield);
			fd.addCtypeInFieldCode(infofield);
		}
		request.getRequestDispatcher("/addCourse.jsp").forward(request, response);
		
		
	}

}
