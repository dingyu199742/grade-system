package test;

import java.sql.*;

public class JdbcTest {
	// JDBC 驱动器名称 和数据库地址
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   //数据库的名称为
	   static final String DB_URL = "jdbc:mysql://localhost/mysql_shiyan?useSSL=false";

	   //  数据库用户和密码
	   static final String USER = "root";

	   static final String PASS = "819970607@@";

	   public static void main(String[] args) {
	       Connection conn = null;
	       Statement stmt = null;
	       try{
	           //注册JDBC 驱动程序
	           Class.forName("com.mysql.jdbc.Driver");

	           //打开连接
	           System.out.println("Connecting to database...");
	           conn = DriverManager.getConnection(DB_URL,USER,PASS);

	           //执行查询
	           System.out.println("Creating statement...");
	           stmt = conn.createStatement();
	           String sql;
	           sql = "SELECT id, name, age FROM students";
	           ResultSet rs = stmt.executeQuery(sql);

	           //得到和处理结果集
	           while(rs.next()){
	               //检索
	               int id  = rs.getInt("id");
	               int age = rs.getInt("age");
	               String name = rs.getString("name");

	               //显示
	               System.out.print("ID: " + id);
	               System.out.print(", Age: " + age);
	               System.out.print(", Name: " + name);
	               System.out.println();
	           }
	           //清理环境
	           rs.close();
	           stmt.close();
	           conn.close();
	       }catch(SQLException se){
	           // JDBC 操作错误
	           se.printStackTrace();
	       }catch(Exception e){
	           // Class.forName 错误
	           e.printStackTrace();
	       }finally{
	           //这里一般用来关闭资源的
	           try{
	               if(stmt!=null)
	                   stmt.close();
	           }catch(SQLException se2){
	           }
	           try{
	               if(conn!=null)
	                   conn.close();
	           }catch(SQLException se){
	               se.printStackTrace();
	           }
	       }
	       System.out.println("Goodbye!");
	   }
}



