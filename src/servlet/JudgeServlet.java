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
import Util.JudgeUtil;
import dao.CourseDao;
import dao.FieldDao;
import dao.ScoreDao;
import dao.StudentDao;
import entity.Score;
import entity.Student;

public class JudgeServlet extends HttpServlet {

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
		JudgeUtil ju=new JudgeUtil();
		HttpSession session1=request.getSession();
		Student onlinestudent=(Student)session1.getAttribute("onlinestudent");
		
		HttpSession session2=request.getSession();
		String field=(String)session2.getAttribute("selectedField");
		
		request.setAttribute("field",field);
		
		HttpSession session3=request.getSession();
		Map<String, Score> selectedScores=(Map<String, Score>)session3.getAttribute("selectedScores");
		
		FieldDao fd=new FieldDao();
		
		// 四选二， 应数专业知识选修，信计专业知识选修， 工作技能课(选修)，学科基础课(选修)
		String[] EPC1 = new String[50], EPC=new String[50], EPC22=new String[50];
		String[] EJSC=new String[50], ESBC=new String[50];
		
		int count1=0, count2=0, count3=0, count4=0, count5=0;
		String code;
		for (Score e : selectedScores.values()) {
			code=e.getCcode();
			
			String ctype=fd.findCtypeInFieldCode(code, field).getCtype();
			if (ctype.equals("EPC1")){
				EPC1[count1]=new String(code);
				count1++;
			}
			if (ctype.equals("EPC1") || ctype.equals("EPC2")){
				EPC[count2]=new String(code);
				count2++;
			}
			if (ctype.equals("EPC")){
				EPC22[count3]=new String(code);
				
				count3++;
			}
			if (ctype.equals("EJSC")){
				EJSC[count4]=new String(code);
				count4++;
			}
			if (ctype.equals("ESBC")){
				ESBC[count5]=new String(code);
				count5++;
			}
				
		}
		
		if (ju.judgeNonstandardinEPC1(EPC1, onlinestudent)){
			request.setAttribute("msg", "专业知识课(选修)中的 四选二 部分课程选择不规范！请重新选择！");
			request.getRequestDispatcher("/initialComputingServlet").forward(request, response);
		}		
		else if (ju.judgeNonstandardinEPC2(EPC, onlinestudent)){
			request.setAttribute("msg", "专业知识课(选修)中的 其他 部分课程选择不规范！请重新选择！");
			request.getRequestDispatcher("/initialComputingServlet").forward(request, response);
		}	
		else if (ju.judgeNonstandard(EPC22, "EPC", onlinestudent)){
			request.setAttribute("msg", "专业知识课(选修)部分课程选择不规范！请重新选择！");
			request.getRequestDispatcher("/initialComputingServlet").forward(request, response);
		}	
		else if (ju.judgeNonstandard(EJSC, "EJSC", onlinestudent)){
			request.setAttribute("msg", "工作技能课(选修)部分课程选择不规范！请重新选择！");
			request.getRequestDispatcher("/initialComputingServlet").forward(request, response);
		}
		else if (ju.judgeNonstandard(ESBC, "ESBC", onlinestudent)){
			request.setAttribute("msg", "学科基础课(选修)部分课程选择不规范！请重新选择！");
			request.getRequestDispatcher("/initialComputingServlet").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/saveSelectedInfoServlet").forward(request, response);
		}
	}

}