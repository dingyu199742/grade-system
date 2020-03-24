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

import Util.ComputeUtil;
import Util.MajorUtil;
import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import entity.Score;
import entity.Student;

public class InitialComputingServlet extends HttpServlet {

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
		HttpSession session=request.getSession();
		Student onlinestudent=(Student)session.getAttribute("onlinestudent");
		
		MajorUtil mu=new MajorUtil();
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map=new LinkedHashMap <String, Score>();
		
		String field=request.getParameter("field");
		if (field.equals("a")){
			field="信息科学";
		}
		if (field.equals("b")){
			field="计算科学";
		}
		if (field.equals("c")){
			field="应用数学";
		}
		if (field.equals("d")){
			field="数理统计";
		}
		if (field==null){
			field=(String)request.getAttribute("field");
		}
		String msg=(String)request.getAttribute("msg");
		//更新 专业方向 专业
		StudentDao sd2=new StudentDao();
		try {
			sd2.updateStudentField(onlinestudent.getSid(), field);
			onlinestudent.setSfield(field);
			sd2.updateMajor(onlinestudent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//系统选择课程
		if (mu.getMajor(field).equals("信息与计算科学")){
			
			map=sd.selectStuScoreOfComputingToCompute(onlinestudent.getSid());
		}
		
		else{
			map=sd.selectStuScoreOfMathToCompute(onlinestudent.getSid());
		}

		//记录总学分
		double credit=0;
		for (Score e:map.values()){
			credit+=cd.findOneCourse(e.getCcode()).getCredit();
		}
		
		ComputeUtil cu=new ComputeUtil();
		HttpSession session2=request.getSession();
		session2.setAttribute("selectedScores",map);
		
		HttpSession session3=request.getSession();
		session3.setAttribute("selectedField",field);
		
		double avegrade=cu.computingAvegrade(map);
		HttpSession session4=request.getSession();
		session4.setAttribute("avegrade",avegrade);
		
		HttpSession session5=request.getSession();
		session5.setAttribute("credit",credit);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/compute.jsp").forward(request, response);
			
		
	}

}
