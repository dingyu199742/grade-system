package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;

public class AddStudentServlet extends HttpServlet {

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
		String id=(String)request.getParameter("id");
		String name=(String)request.getParameter("name");
		String sclass=(String)request.getParameter("class");
		StudentDao sd=new StudentDao();
		if(sd.findOneStudent(id)!=null){
			request.setAttribute("msg", "该学生已存在！");
		}else{
			if(sd.addStudentIncludeClass(id, name, sclass)){
				request.setAttribute("msg", "添加成功！");
			}else{
				request.setAttribute("msg", "添加失败，请重试！");
			}
		}
		request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
		
	}



}
