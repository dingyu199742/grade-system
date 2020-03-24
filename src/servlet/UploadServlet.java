package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.InformationDao;
import entity.Information;
import Util.DateUtil;
//16进制包
import Util.HexStrUtil;

/**
 * 用于文件上传测试的servlet
 * 进行文件上传时,只能使用post方式提交表单
 * @author Administrator
 *
 */
public class UploadServlet extends HttpServlet{

    /**
     * 测试文件上传工具:commons-fileupload的使用方式
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	Date nowDate=new Date();// new Date()为获取当前系统时间
    	DateUtil du=new DateUtil();
    	String time=du.getStringfromDate("yyyy-MM-dd HH:mm:ss", nowDate);
    	InformationDao id=new InformationDao();
    	Information info=new Information();
    	info.setTime(time);
    	//用于设置文件上传时的临时文件的目录等信息
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //生成核心对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //使用核心对象对请求输入流进行解析
        try {
            List<FileItem> parseRequest = upload.parseRequest(req);
            for (FileItem fileItem : parseRequest) {
                if (fileItem.isFormField()) {
                	//文本部分：
                	//System.out.println("111");
                	
                    //普通上传项(得到名和值)
                    String fieldName = fileItem.getFieldName();
                    String value = fileItem.getString();
                    String str = new String(value.getBytes("ISO-8859-1"),"UTF-8");
                   
                    if (id.findOneInformation(str,time)!=null){
                    	req.setAttribute("msg", "文件名重复！请重新命名");
                    	req.getRequestDispatcher("/XinxiManage.jsp").forward(req, resp);
                    }
                    
                    //文本数据处理：
                    if(fieldName.equals("biaoQian")){
                    	req.setAttribute("biaoQian", str);
                    	info.setBiaoqian(str);
                    }else if(fieldName.equals("longText")){
                    	req.setAttribute("longText", str);
                    	info.setLongText(str);
                    }
                    
                    //测试普通项
                    System.out.println(fieldName+"="+str);
                } else {
                	//System.out.println("222");
                    //文件上传项(得到名,文件名,文件内容输入流,创建文件输出流,把上传文件写入服务器磁盘)
                    //从文件项对象中得到输入流
                    InputStream is = fileItem.getInputStream();

                    //16进制
                    HexStrUtil hexStrUtil=new HexStrUtil();
                    //创建一个磁盘文件的输出流
                    FileOutputStream fis = new FileOutputStream(getServletContext().getRealPath("/files")+"\\"+hexStrUtil.str2HexStr(fileItem.getName()+info.getTime()));
                    
                    //文件数据处理：
                    info.setFilePath(getServletContext().getRealPath("/grade_srdp/files"));
                    req.setAttribute("filePath", info.getFilePath());
                    info.setFileName(fileItem.getName());
                    req.setAttribute("fileName", fileItem.getName());
                    
                    System.out.println("3："+getServletContext().getRealPath("/grade_srdp/files"));
            		System.out.println("4："+fileItem.getName());
            		
                    //流对接
                    byte[] buf= new byte[1024];
                    int len;
                    while ((len = is.read(buf)) > 0) {
                        fis.write(buf, 0, len);
                    }

                    fis.close();
                }
            }
            id.addInformation(info);
            req.setAttribute("msg", "上传成功！");
            req.setAttribute("fileName", info.getFileName());
            req.setAttribute("time", info.getTime());
			req.getRequestDispatcher("/findOneNewsServlet?op=find").forward(req, resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
