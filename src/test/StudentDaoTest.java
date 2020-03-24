package test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

import Util.ComputeUtil;
import dao.ScoreDao;
import dao.StudentDao;
import entity.Score;
import entity.Student;

public class StudentDaoTest {

	public static void main(String[] args) {
		// 测试StudentDao addStudent()
		//StudentDao sd=new StudentDao();
		//sd.addStudent("16160001089", "小yyyy");
		
		// 测试StudentDao delStudent()
		//StudentDao sd=new StudentDao();
		//sd.delStudent("16160001034");
		
		//测试StudentDao updateStudentField()
		//StudentDao sd=new StudentDao();
		//sd.updateStudentField("15160001089", "math");
		
		//测试StudentDao  updateStudentClass()
		//StudentDao sd=new StudentDao();
		//sd.updateStudentClass("15160001089", "3");
		
		//测试StudentDao  updateStudentPassword()
		//StudentDao sd=new StudentDao();
		//sd.updateStudentPassword("15160001089", "77777");

		//测试StudentDao   findAllStudent()
		/*
		StudentDao sd=new StudentDao();
		Map<String, Student> map = sd.findAllStudent();
		for (Student e : map.values()) {
			System.out.println(e.getSid()+"， " + e.getSname()+ "， " +e.getMajor());

		}
		*/
		
		//测试StudentDao   findOneStudent()
		
		StudentDao sd=new StudentDao();
		Student student =sd.findOneStudent("16160001078");
		System.out.println(student.getSid()+"，"+student.getSname()+"，"+student.getSfield());
			
		//测试StudentDao  getMajor()
		//StudentDao sd=new StudentDao();
		//System.out.println(sd.getMajor("数理统计"));
		
		//测试 RankDao updateMajor()
		/*
		StudentDao sd=new StudentDao();
		Student student=sd.findOneStudent("16160001078");
		sd.updateMajor(student);
		*/
		
		//测试 computingAvegrade()
		/*
		ScoreDao sd=new ScoreDao();
		Map<String, Score> map =sd.selectStuScoreOfMathToCompute("16160001078");
		double avegrade=ComputeUtil.computingAvegrade(map);
		System.out.println("平均学分绩："+avegrade);
		*/
		
		//测试 RankDao updateStudentAvegrade()
		/*
		ScoreDao sd1=new ScoreDao();
		StudentDao sd2=new StudentDao();
		Map<String, Score> map =sd1.selectStuScoreOfMathToCompute("16160001078");
		System.out.println(sd2.updateStudentAvegrade("16160001078", map));
		*/
		
		//测试 RankDao isRanked()
		//StudentDao sd=new StudentDao();
		//System.out.println(sd.isRanked("16160001078", 91));
		
		//测试 RankDao updateIsRanked()
		//StudentDao sd=new StudentDao();
		//System.out.println(sd.updateIsRanked("16160001078", 92));
		
		//测试 RankDao scoreRank() scoreRankAsMajor
		/*
		StudentDao sd=new StudentDao();
		Map<Integer, Student> map=sd.scoreRankAsMajor("信息与计算科学");
		for (Map.Entry<Integer,Student> entry : map.entrySet()) {
			System.out.println("排名："+entry.getKey()+"成绩："+entry.getValue().getAvegrade());
		}
		*/
		
		//测试 RankDao scoreRank() scoreRankAsClass
		/*
		StudentDao sd=new StudentDao();
		Map<Integer, Student> map=sd.scoreRankAsClass("1");
		for (Map.Entry<Integer,Student> entry : map.entrySet()) {
			System.out.println("排名："+entry.getKey()+"成绩："+entry.getValue().getAvegrade());
		}
		*/
		
		//保留三位小数 不四舍五入
		/*
		DecimalFormat formater = new DecimalFormat("#.###");
		formater.setRoundingMode(RoundingMode.FLOOR);
		double avegrade = Double.valueOf(formater.format(0.89575555));
		System.out.println(avegrade);
		*/
		
		
		
		
	}

}
