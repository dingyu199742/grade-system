package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Util.HexStrUtil;
import dao.CourseDao;
import dao.InformationDao;
import entity.Course;
import entity.Information;

public class UpdateNewsServlet extends HttpServlet {

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
		InformationDao id=new InformationDao();
		Information info=new Information();
		//生成核心对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //使用核心对象对请求输入流进行解析
        try {
            List<FileItem> parseRequest = upload.parseRequest(request);
            for (FileItem fileItem : parseRequest) {
                if (fileItem.isFormField()) {
                	//文本部分：
                	//System.out.println("111");
                	
                    //普通上传项(得到名和值)
                    String fieldName = fileItem.getFieldName();
                    String value = fileItem.getString();
                    String str = new String(value.getBytes("ISO-8859-1"),"UTF-8");
                    //文本数据处理：
                    if(fieldName.equals("biaoQian")){
                    	request.setAttribute("biaoQian", str);
                    	info.setBiaoqian(str);
                    }else if(fieldName.equals("longText")){
                    	request.setAttribute("longText", str);
                    	info.setLongText(str);
                    }else if(fieldName.equals("fileName")){
                    	request.setAttribute("fileName", str);
                    	info.setFileName(str);
                    }else if(fieldName.equals("time")){
                    	request.setAttribute("time", str);
                    	info.setTime(str);
                    }else if(fieldName.equals("path")){
                    	request.setAttribute("path", str);
                    	info.setFilePath(str);
                    }
                } 
                    
                } 
            id.updateInformation(info);
            request.setAttribute("msg", "修改成功！");
          
            request.getRequestDispatcher("/findAllNewsServlet?u=admin").forward(request, response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    
	}

}
