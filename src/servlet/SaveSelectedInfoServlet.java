package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.ComputeUtil;
import dao.ScoreDao;
import dao.StudentDao;
import entity.Score;
import entity.Student;

public class SaveSelectedInfoServlet extends HttpServlet {

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
		HttpSession session1=request.getSession();
		Student onlinestudent=(Student)session1.getAttribute("onlinestudent");
		
		HttpSession session2=request.getSession();
		Map<String, Score> selectedScores=(Map<String, Score>)session2.getAttribute("selectedScores");
		
		HttpSession session3=request.getSession();
		String selectedField=(String)session3.getAttribute("selectedField");
		
		HttpSession session4=request.getSession();
		double avegrade=(double) session4.getAttribute("avegrade");
		
		//保存参评课程
		ScoreDao sd2=new ScoreDao();
		for (Score e : selectedScores.values()) {
			sd2.updateIsSelectedTo1(e);
		}
		//保存成绩 确定参评
		StudentDao sd=new StudentDao();
		Student student=sd.findOneStudent(onlinestudent.getSid());
		student.setAvegrade(avegrade);
		student.setIsRanked(1);
		sd.updateStudent(student);
		//onlinestudent.setMajor(student.getMajor());
		
		request.setAttribute("sid", onlinestudent.getSid());
		request.getRequestDispatcher("/findFinalScoreServlet").forward(request, response);
		
	}

}
