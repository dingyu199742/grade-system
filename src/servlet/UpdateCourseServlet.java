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

public class UpdateCourseServlet extends HttpServlet {

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
		String oldCode=(String) request.getParameter("oldCode");
		double credit=Double.valueOf(request.getParameter("credit"));
		String mathtype=(String) request.getParameter("math");
		String protype=(String) request.getParameter("probability");
		String Infotype=(String) request.getParameter("Info");
		String Comtype=(String) request.getParameter("computing");
		Course course=new Course(code, name, credit, oldCode);
		CourseDao cd=new CourseDao();
		cd.updateCourse(course);
		FieldDao fd=new FieldDao();
		Field mathfield=new Field("应用数学", code, mathtype);
		Field profield=new Field("数理统计", code, protype);
		Field comfield=new Field("计算科学", code, Comtype);
		Field infofield=new Field("信息科学", code, Infotype);
		
		fd.updateCtypeInFieldCode(mathfield);
		fd.updateCtypeInFieldCode(profield);
		fd.updateCtypeInFieldCode(comfield);
		fd.updateCtypeInFieldCode(infofield);
		request.setAttribute("msg", "修改成功！");
		request.getRequestDispatcher("/findAllCourseServlet").forward(request, response);
		
	}

}
