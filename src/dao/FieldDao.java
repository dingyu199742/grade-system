package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import entity.Course;
import entity.Field;

public class FieldDao {
	BaseDao bd=new BaseDao();
	
	//找出 tfield(此专业方向下) field 对象
	public  Map<String,Field> findOneField(String tfield){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedHashMap<String, Field> map = new LinkedHashMap<String, Field>();
		String sql="select * from Field where field=?";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, tfield);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String field=rs.getString("field");
				String ccode=rs.getString("ccode");
				String ctype=rs.getString("ctype");
				Field  mfield =new Field(field, ccode, ctype);
				map.put(ccode, mfield);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
	
	}
	//找所有的field对象
	public  Map<String,Field> findAllField(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedHashMap<String, Field> map = new LinkedHashMap<String, Field>();
		String sql="select * from Field";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String field=rs.getString("field");
				String ccode=rs.getString("ccode");
				String ctype=rs.getString("ctype");
				Field  mfield =new Field(field, ccode, ctype);
				map.put(ccode, mfield);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
	
	}
	//更新某专业方向下 code 对应课程的 课程类型
	public boolean updateCtypeInFieldCode(Field field){
		String sql="update field set ctype=? where ccode=? and field=?";
		Object[] values={field.getCtype(),field.getCcode(),field.getField()};
		
		return bd.executeUpdate(sql, values);
	}
	//添加某课程在某专业方向下的课程类型
	public boolean addCtypeInFieldCode(Field field){
		String sql="insert into field(field,ccode,ctype) values (?,?,?)";
		Object[] values={field.getField(),field.getCcode(),field.getCtype()};
		
		return bd.executeUpdate(sql, values);
	}
	// 找出 tfield 专业方向下  tccode(所代表的课程) 所对应的 field对象
	public Field findCtypeInFieldCode(String tccode,String tfield){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field mfield=null;
		String sql="select * from field where ccode=? and field=?";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, tccode);
			ps.setString(2, tfield);
			rs=ps.executeQuery();
			while(rs.next()){
				String ctype=rs.getString("ctype");
				String ccode=rs.getString("ccode");
				String field=rs.getString("field");
				mfield =new Field(field, ccode, ctype);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return mfield;
		
	}
	
	//找出 tfield 专业方向下，tctype 课程类型 下 对应的 field对象
	public  Map<String,Field> findCcodeInFieldCtype(String tctype, String tfield){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Field> map = new HashMap<String, Field>();
		String sql="select * from field where ctype=? and field=?";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, tctype);
			ps.setString(2, tfield);
			rs=ps.executeQuery();
			while(rs.next()){
				String field=rs.getString("field");
				String ccode=rs.getString("ccode");
				String ctype=rs.getString("ctype");
				Field mfield =new Field(field, ccode, ctype);
				map.put(ccode, mfield);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
	
	}

}
