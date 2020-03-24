package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import Util.MajorUtil;
import entity.Field;
import entity.Score;
import entity.Student;

public class ScoreDao {
	BaseDao bd=new BaseDao();
	
	//信计模块学分上限
	static Double C_PBCUL=Double.valueOf(25);//信计_公共基础课
	static Double C_RSBCUL=Double.valueOf(49);//信计_学科基础课_必修
	static Double C_RPCUL=Double.valueOf(23.5);//信计_专业知识课_必修
	static Double C_EPCUL=Double.valueOf(13.5);//信计_专业知识课_选修
	static Double C_RJSCUL=Double.valueOf(7);//信计_工作技能课_必修
	static Double C_EJSCUL=Double.valueOf(4);//信计_工作技能课_选修
	
	public static String[] types=new String[]{"公共基础课","学科基础课(必修)","学科基础课(选修)","专业知识课(必修)",
		"专业知识课(选修)","工作技能课(必修)","工作技能课(选修)"};  
	
	//放在 静态 map里
	public static LinkedHashMap<String, Double> computingCtypesMap=new LinkedHashMap <String, Double>();
	static {
	    computingCtypesMap.put("PBC",C_PBCUL);
	    computingCtypesMap.put("RSBC",C_RSBCUL);
	    computingCtypesMap.put("RJSC",C_RJSCUL);
	    computingCtypesMap.put("EJSC",C_EJSCUL);
	    computingCtypesMap.put("RPC",C_RPCUL);
	    computingCtypesMap.put("EPC",C_EPCUL);
	    
	}
	
	//应数模块学分上限
	static Double M_PBCUL=Double.valueOf(25);//应数_公共基础课
	static Double M_RSBCUL=Double.valueOf(45);//应数_学科基础课_必修
	static Double M_ESBCUL=Double.valueOf(7);//应数_学科基础课_选修
	static Double M_RPCUL=Double.valueOf(16);//应数_专业知识课_必修
	static Double M_EPCUL=Double.valueOf(18);//应数_专业知识课_选修
	static Double M_RJSCUL=Double.valueOf(7);//应数_专业知识课_选修
	static Double M_EJSCUL=Double.valueOf(4);//应数_专业知识课_选修
	
	//放在 静态 map里
	public static LinkedHashMap<String, Double> mathCtypesMap=new LinkedHashMap<String, Double>();
	static {
		mathCtypesMap.put("PBC",M_PBCUL);
		mathCtypesMap.put("RSBC",M_RSBCUL);
		mathCtypesMap.put("ESBC",M_ESBCUL);
		mathCtypesMap.put("RJSC",M_RJSCUL);
		mathCtypesMap.put("EJSC",M_EJSCUL);
		mathCtypesMap.put("RPC",M_RPCUL);
		mathCtypesMap.put("EPC",M_EPCUL);
	    
	}
	
	//找出所有成绩 对应的score对象(成绩由高到低)
	public Map <String, Score> findAllScore(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedHashMap <String, Score> map = new LinkedHashMap <String, Score>();
		String sql="select * from score order by sgrade DESC";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				String sid=rs.getString("sid");
				String ccode=rs.getString("ccode");
				double sgrade=rs.getDouble("sgrade");
				String state=rs.getString("state");
				int term=rs.getInt("term");
				int isSelected=rs.getInt("isSelected");
				//复合主键 key
				String key=sid+ccode+state+term;
				Score score=new Score(sid, ccode, sgrade, state, term, isSelected);
				map.put(key, score);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
	
	}
	
	//找出一个学生所有成绩 所对应的score对象 按照成绩由高到低排序
	public Map<String, Score> findOneStuAllScore(String id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedHashMap <String, Score> map = new LinkedHashMap <String, Score>();
		String sql="select * from score where sid=? order by sgrade DESC";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				String ccode=rs.getString("ccode");
				double sgrade=rs.getDouble("sgrade");
				String state=rs.getString("state");
				int term=rs.getInt("term");
				int isSelected=rs.getInt("isSelected");
				Score score=new Score(id, ccode, sgrade, state, term, isSelected);
				map.put(ccode, score);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
	
	}
	
	//找出 一个学生一门课的成绩 对应的 score
	public Score findOneScore(String id,String code){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Score score=null;
		String sql="select * from Score where sid=? and ccode=?";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, code);
			rs=ps.executeQuery();
			while(rs.next()){
				String ccode=rs.getString("ccode");
				double sgrade=rs.getDouble("sgrade");
				String state=rs.getString("state");
				int term=rs.getInt("term");
				int isSelected=rs.getInt("isSelected");
				score=new Score(id, ccode, sgrade, state, term, isSelected);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return score;
			
	}
	
	//查找某学生(固定专业方向)在某课程类型下已取得分数的score对象(按成绩由高到低)
	//某门课她修过了 但专业方向的此课程类型中 无这门课 则不算在内
	public  Map <String, Score> findStuScoreInOneCtype(String sid, String ctype){
		FieldDao fd=new FieldDao();
		StudentDao sd=new StudentDao();
		Student student =sd.findOneStudent(sid);
		Map <String, Score> map1=findOneStuAllScore(sid);
		
		LinkedHashMap <String, Score> map2=new LinkedHashMap <String, Score>();
		Field field=new Field();
		for (Map.Entry<String, Score> entry : map1.entrySet()) {
			field =fd.findCtypeInFieldCode(entry.getValue().getCcode(), student.getSfield());
			
			if (field.getCtype().equalsIgnoreCase(ctype)){
				map2.put(entry.getKey(), entry.getValue());
				
			}
		}
	    return map2;
		
	}
	
	// 判断一个学生 (固定专业方向)某 有学分要求的课程类型的课是否达到要求(15级除了应数的专业知识选修部分)
	public  boolean isQualified (String sid,String ctype){
		CourseDao cd=new CourseDao();
		MajorUtil mu=new MajorUtil();
		StudentDao sd=new StudentDao();
		Student student=sd.findOneStudent(sid);
		Map <String,Score> map=findStuScoreInOneCtype(sid, ctype);
		double sum=0;
		for (Map.Entry<String, Score> entry : map.entrySet()){
			sum+=cd.findOneCourse(entry.getValue().getCcode()).getCredit();
		}
		if  (mu.getMajor(student.getSfield()).equalsIgnoreCase("数学与应用数学") && sum > mathCtypesMap.get(ctype)){
			return true;
			
		}
		//因为信计没有学科基础选修所以也不会出错
		if  (mu.getMajor(student.getSfield()).equalsIgnoreCase("信息与计算科学") && sum > computingCtypesMap.get(ctype)){
			return true;
			
		}
		
		return false;
		
	}
	
	//判断  学生 (固定专业方向)在有数量要求的 课程类型下(EPC1)是否达到要求 (15级应数专业学生 专业知识选修课的 四选二)
	public boolean isQualifiedInMathEPC1(String sid,String ctype, int num){
		Map <String,Score> map=findStuScoreInOneCtype(sid, ctype);

		int tNum=0;
		for (Map.Entry<String, Score> entry : map.entrySet()){
			tNum++;
			
		}
		//EPC1  数量>2
		if (tNum > num){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//判断 学生 (固定专业方向)应数的专业知识选修部分的EPC2是否达到要求
	public  boolean isQualifiedInMathEPC2(String sid){
		CourseDao cd=new CourseDao();
		Map <String,Score> map1=findStuScoreInOneCtype(sid, "EPC1");
		Map <String,Score> map2=findStuScoreInOneCtype(sid, "EPC2");
		double sum2=0;
		double count=0;
		for (Map.Entry<String, Score> entry : map1.entrySet()){
			count++;
			if (count > 2){
				sum2+=cd.findOneCourse(entry.getValue().getCcode()).getCredit();
			}
		}
		for (Map.Entry<String, Score> entry : map2.entrySet()){
			sum2+=cd.findOneCourse(entry.getValue().getCcode()).getCredit();
		}
		//EPC2 上限12
		if (sum2 > 12){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//(系统)确定一个学生 (固定专业方向)某课程类型下 要参评的课程 对应的score对象(除了应数专业知识课 选修 )
	public  Map <String, Score> selectStuScoreInOneCtypeToCompute(String sid,String ctype){
		CourseDao cd=new CourseDao();
		StudentDao sd=new StudentDao();
		MajorUtil mu=new MajorUtil();
		Student student=sd.findOneStudent(sid);
		Map <String,Score> map=findStuScoreInOneCtype(sid, ctype);
		LinkedHashMap <String, Score> map1=new LinkedHashMap <String, Score>();
		double sum=0;
		for (Map.Entry<String, Score> entry : map.entrySet()){
			
			sum+=cd.findOneCourse(entry.getValue().getCcode()).getCredit();
			map1.put(entry.getKey(), entry.getValue());
			if  (mu.getMajor(student.getSfield()).equalsIgnoreCase("数学与应用数学") && sum >= mathCtypesMap.get(ctype)){
				return map1;
				
			}
			if (mu.getMajor(student.getSfield()).equalsIgnoreCase("信息与计算科学") && sum >= computingCtypesMap.get(ctype)){
				return map1;
				
			}
		}
		
		return map1;
		
	}
	
	// 对(系统)确定一个学生某课程类型下 要参评的课程 在score表做标记
	public boolean updateStuScoreInOneCtypeToCompute(String sid,String ctype){
		String sql="update score set isSelected=? where sid=? and ccode=?";
		
		Map <String,Score> map=selectStuScoreInOneCtypeToCompute(sid, ctype);
		for (String key: map.keySet()){
			Object[] values={1, sid, key};
			if (!bd.executeUpdate(sql, values)){
				return false;
			}
			
		}
		return true;	
		
	}
	//(系统)确定一个学生某课程类型下 要参评的课程 对应的score对象(应数专业知识课 选修 的 四选二部分 )
	public Map <String, Score> selectStuScoreInMathEPC1ToCompute(String sid){
		Map <String,Score> map=findStuScoreInOneCtype(sid, "EPC1");
		LinkedHashMap <String, Score> map2=new LinkedHashMap <String, Score>();
		int count=0;
		for (Map.Entry<String, Score> entry : map.entrySet()){
			count++;
			map2.put(entry.getKey(), entry.getValue());
			if (count == 2){
				return map2;
			}
		}
		
		return map2;
	}
	
	//(系统)确定一个学生某课程类型下 要参评的课程 对应的score对象(应数专业知识课 选修 的 EPC2)
	public Map <String, Score> selectStuScoreInMathEPC2ToCompute(String sid){
		CourseDao cd=new CourseDao();
		Map <String,Score> map0=findStuScoreInOneCtype(sid, "EPC1");
		Map <String, Score> map1=selectStuScoreInMathEPC1ToCompute(sid);
		
		Map <String,Score> map=findStuScoreInOneCtype(sid, "EPC2");
		//按成绩排序后的EPC2+EPC1为参评课程 的score
		LinkedHashMap <String, Score> map2=new LinkedHashMap <String, Score>();
		//按成绩排序后的EPC2+EPC1为参评课程 的score(参评的)
		LinkedHashMap <String, Score> map3=new LinkedHashMap <String, Score>();
		double sum2=0;
		int count=0;
		//按成绩排序后的EPC2+EPC1为参评课程 的课程号
		String[] EPC2 = new String[50];
		for (Map.Entry<String, Score> entry : map0.entrySet()){
			if (map1.get(entry.getValue().getCcode())==null){
				map.put(entry.getKey(), entry.getValue());
			}
		}
		
		for (Map.Entry<String, Score> entry : map.entrySet()){
			EPC2[count]=new String(entry.getValue().getCcode());
			count++;
		}
		
		for (int i=0; i<EPC2.length; i++){
			for(int j = 0;j < EPC2.length-i-1;j++){
				if (map.get(EPC2[j])!=null && map.get(EPC2[j+1])!=null){
					double score1=map.get(EPC2[j]).getSgrade();
					double score2=map.get(EPC2[j+1]).getSgrade();
						if(score1 < score2){  
							String t =EPC2[j];  
							EPC2[j] = EPC2[j+1];  
							EPC2[j+1]= t;  
						}  
				}
            }  
		}
		for (int i=0; i<EPC2.length; i++){
			map2.put(EPC2[i], map.get(EPC2[i]));
		}
		
		for (Map.Entry<String, Score> entry : map2.entrySet()){
			sum2+=cd.findOneCourse(entry.getValue().getCcode()).getCredit();
			map3.put(entry.getKey(), entry.getValue());
			if (sum2 >= 12){
				return map3;
			}
		}
		return map3;
	
	}
	
	
	
	//(系统)确定一个学生 要参评的课程 对应的score对象(信计)
	public Map <String, Score> selectStuScoreOfComputingToCompute(String sid){
		LinkedHashMap <String, Score> map=new LinkedHashMap <String, Score>();
		for (Entry<String, Double> entry : computingCtypesMap.entrySet()){
			Map <String, Score> map1=selectStuScoreInOneCtypeToCompute(sid,entry.getKey());
			for (Entry<String, Score> entry1 : map1.entrySet()){
				map.put(entry1.getKey(), entry1.getValue());
			}
		}
		return map;
		
	}
	
	//(系统)确定一个学生 要参评的课程 对应的score对象(应数)
	public  Map <String, Score> selectStuScoreOfMathToCompute(String sid){
		LinkedHashMap <String, Score> map=new LinkedHashMap <String, Score>();
		String key=null;
		for (Map.Entry<String, Double> entry : mathCtypesMap.entrySet()){
			key=entry.getKey();
			Map <String, Score> mapAll=selectStuScoreInOneCtypeToCompute(sid,key);
			for (Entry<String, Score> entry2 : mapAll.entrySet()){
				map.put(entry2.getKey(), entry2.getValue());
			}
	
		}
		Map<String, Score> mapMathEPC1=selectStuScoreInMathEPC1ToCompute(sid);
		for (Map.Entry<String, Score> entry : mapMathEPC1.entrySet()){
			map.put(entry.getKey(), entry.getValue());
		}
		Map<String, Score> mapMathEPC2=selectStuScoreInMathEPC2ToCompute(sid);
		for (Map.Entry<String, Score> entry : mapMathEPC2.entrySet()){
			map.put(entry.getKey(), entry.getValue());
		}
		
		return map;
	}
	
	//根据score表中的isSelected 标记 选出某学生 某课程类型下 确定参评的课程 反馈给老师
	public  Map <String, Score> findStuScoreSelectedInOneCtype(String sid, String ctype){
		Map <String, Score> map1=findStuScoreInOneCtype(sid, ctype);
		LinkedHashMap <String, Score> map2=new LinkedHashMap <String, Score>();
		
		for (Map.Entry<String, Score> entry : map1.entrySet()) {
			if (entry.getValue().getIsSelected()==1){
				map2.put(entry.getKey(), entry.getValue());
				
			}
		}
	    return map2;
		
	}

	
	//删除部分
	public  boolean delScore(Score score){
		String sql="delete from score where sid=? and ccode=? and state=? and term=? ";
		Object[] values={score.getSid(),score.getCcode(),score.getState(),score.getTerm()};
		return bd.executeUpdate(sql, values);
	}
	
	public boolean delScoreChuxiu(Score score){
		String state="初修取得";	
		String sql="delete from score where sid=? and ccode=? and state=?";
		Object[] values={score.getSid(),score.getCcode(),state};
		return bd.executeUpdate(sql, values);	
	}
	//找出与这门课绑定的课 旧课程号和这门课的课程号相等
	public Map<String, Score> findRelatedScore(Score score){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedHashMap <String, Score> map = new LinkedHashMap <String, Score>();
		String sql="select score.ccode, score.sgrade, score.isSelected, score.state,score.term as term"
				+ " from score, course where score.ccode=course.ccode and score.sid=? and (course.oldCode=? or score.ccode=?) order by term ASC";
		
		try {
			conn=bd.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, score.getSid());
			ps.setString(2, score.getCcode());
			ps.setString(3, score.getCcode());
			rs=ps.executeQuery();
			while(rs.next()){
				String ccode=rs.getString("ccode");
				double sgrade=rs.getDouble("sgrade");
				String state=rs.getString("state");
				int term=rs.getInt("term");
				int isSelected=rs.getInt("isSelected");
				Score score2=new Score(score.getSid(), ccode, sgrade, state, term, isSelected);
				map.put(ccode, score2);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			bd.closeAll(conn, ps, rs);
		}
		return map;
	
	}
	public boolean delShuafen(Score score){
		String state="初修取得";	
		String sql="delete from score where sid=? and ccode=? and state=? and term not in(Select * from ((Select min(term) from score where sid=? and ccode=? and state=?)as s2))";
		Object[] values={score.getSid(),score.getCcode(),state,score.getSid(),score.getCcode(),state};
		Map<String, Score> map =findRelatedScore(score);
		int count=0;
		for (Score e : map.values()) {
			if (count>=1){
				delScore(e);
			}
			count++;
		}
		return bd.executeUpdate(sql, values);	
	}
	
	public boolean delete(Score score){
		CourseDao cd=new CourseDao();
		//查不到这门课就删掉
		if(cd.findOneCourse(score.getCcode())==null){
			return delScore(score);
		}
		//删除补考部分
		if(score.getState().equalsIgnoreCase("补考取得") && score.getSgrade()>=60){
			return delScoreChuxiu(score);
		}
		if(score.getState().equalsIgnoreCase("补考取得") && score.getSgrade()<60){
			return delScore(score);
		}
		//删除缓考部分
		if(score.getState().equalsIgnoreCase("缓考取得") && score.getSgrade()>=60){
			return delScoreChuxiu(score);
		}
		if(score.getState().equalsIgnoreCase("缓考取得") && score.getSgrade()<60){
			return delScore(score);
		}
		//删除重修部分
		if(score.getState().equalsIgnoreCase("重修取得")){
		    return delScore(score);
	    }
		//删除刷分部分
		if(score.getState().equalsIgnoreCase("初修取得")){
			
			return delShuafen(score);
		}
		
		else{
	    	return false;
		 
	    }
	}
	
	//(isSelected)变成1
	public boolean updateIsSelectedTo1(Score score){
		String sql="update score set isSelected=? where sid=? and ccode=?";
		Object[] values1={1, score.getSid(),score.getCcode()};
		return bd.executeUpdate(sql, values1);
	}
	
	//(isSelected)变成0 学生重置
		public boolean updateIsSelectedTo0(Score score){
			String sql="update score set isSelected=? where sid=? and ccode=?";
			Object[] values1={0, score.getSid(),score.getCcode()};
			return bd.executeUpdate(sql, values1);
		}
	//把某学生所有的课程全部重置
		public boolean updateOneStudentIsSelectedTo0(String sid){
			String sql="update score set isSelected=? where sid=?";
			Object[] values1={0, sid};
			return bd.executeUpdate(sql, values1);
		}
	
	
}
