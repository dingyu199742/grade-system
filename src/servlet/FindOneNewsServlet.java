package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InformationDao;
import entity.Information;


public class FindOneNewsServlet extends HttpServlet {

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
		String fileName=(String)request.getParameter("fileName");
		String time=(String)request.getParameter("time");
		String op=(String)request.getParameter("op");
		InformationDao id=new InformationDao();
		Information info=new Information();
		info=id.findOneInformation(fileName,time);
		if (info==null){
			request.setAttribute("msg", "通知不存在！");
			
		}
		else{
			request.setAttribute("news", info);
			request.setAttribute("biaoQian", info.getBiaoqian());
			request.setAttribute("longText", info.getLongText());
			request.setAttribute("filePath", info.getFilePath());
			request.setAttribute("fileName", info.getFileName());
			request.setAttribute("time", info.getTime());
			
		}
		if(op.equals("update")){
			request.getRequestDispatcher("/updateNews.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/showOneNews.jsp").forward(request, response);
		}
		
	}

}
