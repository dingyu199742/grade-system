package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import entity.Information;

public class InformationDao {
	//添加一个Information
	BaseDao bd=new BaseDao();
	public  boolean addInformation(Information info){
		String sql = "insert into information(description,biaoqian,fileName,filePath,time) values (?,?,?,?,?)";
		Object[] values = {info.getLongText(), info.getBiaoqian(), info.getFileName(), info.getFilePath(), info.getTime()};
		return bd.executeUpdate(sql, values);
			
	}
	//只能修改描述 标签
	public boolean updateInformation(Information info){
		String sql="update information set description=?, biaoqian=?, filePath=? where fileName=? and time=?";
		Object[] values={info.getLongText(), info.getBiaoqian(), info.getFilePath(), info.getFileName(),info.getTime()};
		return bd.executeUpdate(sql, values);
	
	}
	public boolean deleteInformation(Information info){
		String sql="delete from information where fileName=? and time=?";
		Object[] values={info.getFileName(),info.getTime()};
		return bd.executeUpdate(sql, values);
	
	}
	public Map<String,Information> findAllInformation(){
		
		Map<String,Information> map=new HashMap<String,Information>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from information";
		
		try{
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String longText=rs.getString("description");
				String biaoqian=rs.getString("biaoqian");
				String filePath=rs.getString("filePath");
				String fileName=rs.getString("fileName");
				String time=rs.getString("time");
				Information info=new Information(longText, biaoqian, fileName, filePath, time);
				map.put(fileName+time, info);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bd.closeAll(conn, ps, rs);
		}
		return map;
	}
	
	public Information findOneInformation(String fileName,String time){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Information info=null;
		String sql="select * from information where fileName=? and time=?";
		
		try{
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, fileName);
			ps.setString(2, time);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String longText=rs.getString("description");
				String biaoqian=rs.getString("biaoqian");
				String filePath=rs.getString("filePath");
				
				info=new Information(longText, biaoqian, fileName, filePath, time);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bd.closeAll(conn, ps, rs);
		}
		return info;
		
	}
	

}
