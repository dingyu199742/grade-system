package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	//JDBC 驱动器名称
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	//数据库地址
	public static final String DB_URL="jdbc:mysql://localhost:3306/gradersrdp?useUnicode=true&amp;characterEncoding=UTF8";
	//用户和密码
	public static final String USER="root";
	public static final String PASSWORD="dingyu3157771";
	//注册JDBC驱动  （静态代码块）类加载的时候执行
	static{
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("1:未导包2:驱动名称错误！");
			e.printStackTrace();
		}
		
	}
	
	
	//创建数据库连接
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("1：地址错误:2：用户名或密码错误！");
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	//关闭所有资源
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
		
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	
	//实现增删改功能 ( 因为查询的多样性,通用的函数并不能简化多少代码 )
	
	
	
	public boolean executeUpdate(String sql, Object[] values){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			for(int i=0;i<values.length;i++){
				ps.setObject(i+1, values[i]);
			}
			int row=ps.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, null);
		}
		return false;
		
	}
}



