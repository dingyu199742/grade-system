package test;

import java.util.Map;

import dao.CourseDao;
import dao.FieldDao;
import dao.ScoreDao;
import entity.Score;

public class ScoreDaoTest {

	public static void main(String[] args) {
		//测试ScoreDao findAllScore()
		/*
		ScoreDao sd=new ScoreDao();
		Map<String, Score> map =sd.findAllScore();
		int count=0;
		for (Score e : map.values()) {
			System.out.println(e.getSid()+"， " + e.getCcode()+ "， "+ e.getSgrade());
			count++;
		}
		System.out.println("总数："+count);
		*/
		
		//测试ScoreDao findOneStuAllScore()
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map =sd.findOneStuAllScore("16160001078");
		for (Score e : map.values()) {
			System.out.println(e.getState()+"， " + e.getCcode()+ "， " +cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade());

		}
		*/
		
		//测试ScoreDao findOneScore()
		/*
		ScoreDao sd=new ScoreDao();
		Score score=sd.findOneScore("16160001078", "075103201233");
		System.out.println(score.getSgrade());
		*/
		
		//测试ScoreDao  findStuScoreInOneCtype
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map3 =sd.findStuScoreInOneCtype("16160001078", "PBC");
		if (map3.isEmpty()){
			System.out.println("空");
		}
		for (Score e : map3.values()) {
			System.out.println(e.getCcode()+ "， " +cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade());

		}
		*/
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map2 =sd.findStuScoreInOneCtype("16160001078", "RPC");
		for (Score e2 : map2.values()) {
			System.out.println(e2.getCcode()+ "， " +cd.findOneCourse(e2.getCcode()).getCname()+"，" + e2.getSgrade());

		}
		*/
		
		//测试ScoreDao  isQualified()
		/*
		ScoreDao sd=new ScoreDao();
		
		boolean isQualified=sd.isQualified("16160001078","RPC");
		System.out.println(isQualified);
		*/
		
		//测试ScoreDao isQualifiedInMathEPC1
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		boolean isQualified=sd.isQualifiedInMathEPC1("16160001078", "EPC1", 2);
		System.out.println(isQualified);
		*/
		
		//测试ScoreDao isQualifiedInMathEPC2
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		boolean isQualified=sd.isQualifiedInMathEPC2("16160001078");
		System.out.println(isQualified);
		Map<String, Score> map2 =sd.findStuScoreInOneCtype("16160001078", "EPC2");
		for (Score e2 : map2.values()) {
			System.out.println(e2.getCcode()+ "， " +cd.findOneCourse(e2.getCcode()).getCname()+"，" + e2.getSgrade());

		}
		*/
		
		//测试ScoreDao selectStuScoreInOneCtypeToCompute
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map=sd.selectStuScoreInOneCtypeToCompute("16160001069", "EPC");
		for (Score e : map.values()) {
			System.out.println(e.getCcode()+ "， "+cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade());

		}
		System.out.println("全部：");
		Map<String, Score> map2 =sd.findStuScoreInOneCtype("16160001069", "EPC");
		for (Score e2 : map2.values()) {
			System.out.println(e2.getCcode()+ "， " +cd.findOneCourse(e2.getCcode()).getCname()+"，" + e2.getSgrade());

		}
		*/
		
		//测试ScoreDao ScoreDao.selectStuScoreInMathEPC1ToCompute
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		System.out.println("EPC1");
		Map<String, Score> map=sd.selectStuScoreInMathEPC1ToCompute("16160001078");
		for (Score e : map.values()) {
			System.out.println(e.getCcode()+ "， " +cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade()+"，"+cd.findOneCourse(e.getCcode()).getCredit());
			
		}
		*/
		
		//测试ScoreDao ScoreDao.selectStuScoreInMathEPC2ToCompute
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		System.out.println("EPC2");
		Map<String, Score> map2=sd.selectStuScoreInMathEPC2ToCompute("16160001078");
		for (Score e : map2.values()) {
			System.out.println(e.getCcode()+ "， " +cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade()+"，"+cd.findOneCourse(e.getCcode()).getCredit());
			
		}
		*/
		
		
		//测试ScoreDao  selectStuScoreOfComputingToCompute
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map=sd.selectStuScoreOfComputingToCompute("16160001069");
		for (Score e : map.values()) {
			System.out.println(e.getCcode()+ "， " +cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade()+"，"+cd.findOneCourse(e.getCcode()).getCredit());
			
		}
		*/
		
		//测试ScoreDao   ScoreDao.selectStuScoreOfMathToCompute
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		FieldDao fd=new FieldDao();
		Map<String, Score> map=sd.selectStuScoreOfMathToCompute("16160001078");
		for (Score e : map.values()) {
			System.out.println(e.getCcode()+ "， "+fd.findCtypeInFieldCode(e.getCcode(), "数理统计").getCtype()+
					"，"+cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade()+
					"，"+cd.findOneCourse(e.getCcode()).getCredit());
			
		}
		*/
		/*
		ScoreDao sd=new ScoreDao();
		CourseDao cd=new CourseDao();
		Map<String, Score> map4 =sd.findStuScoreSelectedInOneCtype("16160001078", "EPC2");
		for (Score e : map4.values()) {
			System.out.println(e.getCcode()+ "， " +cd.findOneCourse(e.getCcode()).getCname()+"，" + e.getSgrade());

		}
		*/
		//测试ScoreDao delScore
		/*
		ScoreDao sd=new ScoreDao();
	
		Score score=new Score("16160001078", "075303201313", 67, "chongxiu", 20171, null);
		System.out.println(sd.delScore(score));
		*/
		
		//测试ScoreDao delScoreChuxiu
		/*
		ScoreDao sd=new ScoreDao();
		
		Score score=new Score();
		score.setSid("16160001078");
		score.setCcode("5555");
		System.out.println(sd.delScoreChuxiu(score));
		*/
		
		//测试ScoreDao delShuafen
		/*
		ScoreDao sd=new ScoreDao();
		
		Score score=new Score();
		score.setSid("16160001078");
		score.setCcode("075303201313");
		System.out.println(sd.delShuafen(score));
		*/
		
		//测试ScoreDao delete()
		/*
		ScoreDao sd=new ScoreDao();
		
		Map<String, Score> map=ScoreDao.findAllScore();
		for (Score e : map.values()) {
			System.out.println(sd.delete(e));
		}
		*/
		
		//测试ScoreDao  updateIsSelected()
		//ScoreDao sd=new ScoreDao();
		//CourseDao cd=new CourseDao();
		//Score score=new Score("16160001069", "075103201233");
		//System.out.println(sd.updateIsSelectedTo1(score));
		//System.out.println(sd.updateIsSelectedTo0(score));
		
		
		
		
	}

}
