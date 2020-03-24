package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import Util.ComputeUtil;
import Util.MajorUtil;
import Util.RankUtil;
import entity.Score;
import entity.Student;

public class StudentDao {
	BaseDao bd = new BaseDao();
	//学生登录
	public Student loginStudent(Student stu) {
		StudentDao sd=new StudentDao();
		Student stu2=sd.findOneStudent(stu.getSid());
		if (stu2!=null && stu2.getPassword().equals(stu.getPassword())){
			return stu2;
		}
		else{
			return null;
		}
	}
	//添加一个学生 (学号，姓名)
	public  boolean addStudent(String sid, String sname){
		String sql = "insert into student(sid,sname,isRanked,password) values (?,?,?,?)";
		Object[] values = {sid, sname, 0, "1234"};
		return bd.executeUpdate(sql, values);
		
	}
	//添加一个学生 (学号，姓名,班级)
	public  boolean addStudentIncludeClass(String sid, String sname,String sclass){
		String sql = "insert into student(sid,sname,sclass,isRanked,password) values (?,?,?,?,?)";
		Object[] values = {sid, sname, sclass,0, "1234"};
		return bd.executeUpdate(sql, values);
			
	}
	//删除一个学生
	public boolean delStudent(String sid){
		String sql="delete from student where sid=?";
		Object[] values={sid};
		
		return bd.executeUpdate(sql, values);
	}
	//修改  姓名 班级 密码 密码
		public boolean updateStudent1(String sid,String sname,String sclass,String spassword ){
			String sql="update student set sname=?, sclass=?, password=? where sid=?";
			Object[] values={sname,sclass,spassword,sid};
			
			return bd.executeUpdate(sql, values);
		}	
	//修改 专业方向
	public boolean updateStudentField(String sid, String sfield){
		String sql="update student set sfield=? where sid=?";
		Object[] values={sfield, sid};
		
		return bd.executeUpdate(sql, values);
	}
	
	//也应该重置课程的参评情况即 isSelected!!!!这里还需修改
	public boolean refreshStudent(String sid){
		String sql="update student set sfield=?, major=?, avegrade=?, isRanked=? where sid=?";
		double avegrade=0;
		Object[] values={null,null,null,0,sid};
		
		return bd.executeUpdate(sql, values);
	}
	//修改 班级
	public boolean updateStudentClass(String sid, String sClass){
		String sql="update student set sClass=? where sid=?";
		Object[] values={sClass, sid};
		
		return bd.executeUpdate(sql, values);
	}
	
	//修改密码
	public boolean updateStudentPassword(String sid, String password){
		String sql="update student set password=? where sid=?";
		Object[] values={password, sid};
		
		return bd.executeUpdate(sql, values);
	
	}
	//修改其他信息
	public boolean updateStudent(Student stu){
		String sql="update student set sname=?, avegrade=?, isRanked=? where sid=?";
		Object[] values={stu.getSname(), stu.getAvegrade(),stu.getIsRanked(),stu.getSid()};
		
		return bd.executeUpdate(sql, values);
	
	}	
	
	// 更新 student 表学生的专业
	public boolean updateMajor(Student student){
		MajorUtil mu=new MajorUtil();
		String sql="update student set major=? where sid=?";
		Object[] values={mu.getMajor(student.getSfield()),student.getSid()};
		
		return bd.executeUpdate(sql, values);
				
	}
	
	//更新学生 根据 map 中课程计算的 加权平均成绩
	public  boolean updateStudentAvegrade(String sid, Map <String, Score> map){
		double avegrade;
		ComputeUtil cu=new ComputeUtil();
		avegrade = cu.computingAvegrade(map);
		String sql="update student set avegrade=? where sid=?";
		Object[] values={avegrade,sid};
		
		return bd.executeUpdate(sql, values);
	}
	
	//更新rank表 学生是否可以参评的信息
	public  boolean updateIsRanked(String sid, double credit){
		RankUtil ru=new RankUtil();
		String sql="update student set isRanked=? where sid=?";
		if (ru.isRanked(sid, credit)){
			Object[] values={1,sid};
			return bd.executeUpdate(sql, values);
		}
		else {
			Object[] values={0,sid};
			return bd.executeUpdate(sql, values);
		}
			
	}
	
	// ?
	public Student initEntity(ResultSet rs) throws Exception{
		Student student=new Student();
		student.setSid(rs.getString("sid"));
		student.setSname(rs.getString("sname"));
		student.setSclass(rs.getString("sclass"));
		student.setSfield(rs.getString("sfield"));
		return student;
	}
	
	public Map<String,Student> findAllStudent(){
		
		Map<String,Student> map=new HashMap<String,Student>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from student";
		
		try{
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String sid=rs.getString("sid");
				String sname=rs.getString("sname");
				double avegrade=rs.getDouble("avegrade");
				String major=rs.getString("major");
				String sfield=rs.getString("sfield");
				String sclass=rs.getString("sclass");
				int isRanked=rs.getInt("isRanked");
				String password=rs.getString("password");
				Student student=new Student(sid, sname, avegrade, major, sfield, sclass, isRanked, password);
				map.put(sid, student);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bd.closeAll(conn, ps, rs);
		}
		return map;
	}
	
	public Student findOneStudent(String sID){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student student=null;
		String sql="select * from student where sid=?";
		
		try{
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, sID);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String sid=rs.getString("sid");
				String sname=rs.getString("sname");
				double avegrade=rs.getDouble("avegrade");
				String major=rs.getString("major");
				String sfield=rs.getString("sfield");
				String sclass=rs.getString("sclass");
				int isRanked=rs.getInt("isRanked");
				String password=rs.getString("password");
				student=new Student(sid, sname, avegrade, major, sfield, sclass, isRanked, password);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bd.closeAll(conn, ps, rs);
		}
		return student;
		
	}
	
	//取出某专业 参评的学生 按平均学分绩 将序排列 的 rank + 排名 信息
	public   Map <Integer, Student> scoreRankAsMajor(String major){
		LinkedHashMap <Integer, Student> map=new LinkedHashMap <Integer, Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer count=0;
		String sql="select sid, sname, avegrade, sfield, sclass from student where major=? and isRanked=1 order by avegrade DESC";
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, major);
			rs=ps.executeQuery();
			while(rs.next()){
				count++;
				String sid=rs.getString("sid");
				String sname=rs.getString("sname");
				double avegrade=rs.getDouble("avegrade");
				String sfield=rs.getString("sfield");
				String sclass=rs.getString("sclass");
				Student student=new Student(sid, sname, avegrade, major, sfield, sclass);
				map.put(count,student);
					
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
				
		} finally {
			bd.closeAll(conn, ps, rs);
		}
			
		return map;
			
	}

	//取出某 行政班级  参评的学生 按平均学分绩 将序排列 的 rank + 排名 信息
	public  Map <Integer, Student> scoreRankAsClass(String sclass){
		LinkedHashMap <Integer, Student> map=new LinkedHashMap <Integer, Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer count=0;
		String sql="select sid, sname, avegrade, major, sfield from student where sclass=? and isRanked=1 order by avegrade DESC";
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, sclass);
			rs=ps.executeQuery();
			while(rs.next()){
				count++;
				String sid=rs.getString("sid");
				String sname=rs.getString("sname");
				double avegrade=rs.getDouble("avegrade");
				String major=rs.getString("major");
				String sfield=rs.getString("sfield");
				Student student=new Student(sid, sname, avegrade, major, sfield, sclass);
				map.put(count,student);
						
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
					
		} finally {
			bd.closeAll(conn, ps, rs);
		}
				
		return map;
				
	}
	public   Map <Integer, Student> scoreAllRank(){
		LinkedHashMap <Integer, Student> map=new LinkedHashMap <Integer, Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer count=0;
		String sql="select sid, sname, avegrade, major, sfield, sclass from student where isRanked=1 order by avegrade DESC";
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				count++;
				String sid=rs.getString("sid");
				String sname=rs.getString("sname");
				double avegrade=rs.getDouble("avegrade");
				String major=rs.getString("major");
				String sfield=rs.getString("sfield");
				String sclass=rs.getString("sclass");
				Student student=new Student(sid, sname, avegrade, major, sfield, sclass);
				map.put(count,student);
					
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
				
		} finally {
			bd.closeAll(conn, ps, rs);
		}
			
		return map;
			
	}
	//根据姓名,学号模糊查找学生
			public Map<String,Student> findStudentByNameAndID(String sname,String sid){
				
				LinkedHashMap<String,Student> map=new LinkedHashMap<String,Student>();
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				String sql="select * from student where sname LIKE concat(?,'%') AND sid LIKE concat(?,'%')";
				
				try{
					conn=bd.getConnection();
					ps=conn.prepareStatement(sql);
					ps.setString(1, sname);
					ps.setString(2, sid);
					rs=ps.executeQuery();
					
					while(rs.next()){
						String sid1=rs.getString("sid");
						String sname1=rs.getString("sname");
						double avegrade=rs.getDouble("avegrade");
						String major=rs.getString("major");
						String sfield=rs.getString("sfield");
						String sclass=rs.getString("sclass");
						int isRanked=rs.getInt("isRanked");
						String password=rs.getString("password");
						Student student=new Student(sid1, sname1, avegrade, major, sfield, sclass, isRanked, password);
						map.put(sid1, student);
						
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					bd.closeAll(conn, ps, rs);
				}
				return map;
			}	
}
