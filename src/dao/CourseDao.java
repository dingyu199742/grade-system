package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import entity.Course;
import entity.Student;



public class CourseDao {
	BaseDao bd=new BaseDao();
	public  boolean addCourse(Course course){
		String sql = "insert into course(ccode,cname,credit,oldCode) values (?,?,?,?)";
		Object[] values = {course.getCcode(), course.getCname(), course.getCredit(), course.getOldCode()};
		return bd.executeUpdate(sql, values);
			
	}
	public boolean updateCourse(Course course){
		String sql="update course set cname=?, credit=?, oldCode=?  where ccode=?";
		Object[] values={course.getCname(), course.getCredit(), course.getOldCode(), course.getCcode()};
		return bd.executeUpdate(sql, values);
	
	}
	public boolean deleteCourse(Course course){
		String sql="delete from course where ccode=?";
		Object[] values={course.getCcode()};
		return bd.executeUpdate(sql, values);
	
	}
	//找出所有的课程对象
	public  Map<String, Course> findAllCourse(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, Course> map = new HashMap<String, Course>();
		String sql="select * from course";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				String ccode=rs.getString("ccode");
				String cname=rs.getString("cname");
				double credit=rs.getDouble("credit");
				String oldCode=rs.getString("oldCode");
				Course course=new Course(ccode, cname, credit,oldCode);
				map.put(ccode, course);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
		
	}

	//根据 code 找出一门课程
	public  Course findOneCourse(String code){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course course = null;
		String sql="select * from course where ccode=?";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, code);
			rs=ps.executeQuery();
			while(rs.next()){
				String ccode=rs.getString("ccode");
				String cname=rs.getString("cname");
				Double credit=rs.getDouble("credit");
				String oldCode=rs.getString("oldCode");
				course=new Course(ccode, cname, credit, oldCode);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return course;
		
	}
	//根据课程号,课程名模糊查找课程
	public Map<String, Course> findCourseByNameAndCode(String cname,String ccode){
		
		Map<String,Course> map=new HashMap<String,Course>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Course course = null;
		String sql="select * from course where cname LIKE concat(?,'%') AND ccode LIKE concat(?,'%')";
		
		try{
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, ccode);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String code=rs.getString("ccode");
				String name=rs.getString("cname");
				Double credit=rs.getDouble("credit");
				String oldCode=rs.getString("oldCode");
				course=new Course(code, name, credit, oldCode);
				map.put(code, course);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bd.closeAll(conn, ps, rs);
		}
		return map;
	}	
}
