package Util;

import dao.ScoreDao;
import entity.Student;

public class RankUtil {
	//根据学生参评的总学分判断 是否可以参评
	public boolean isRanked(String sid, double credit){
		double sum=0;
		MajorUtil mu=new MajorUtil();
		if (mu.getMajor(sid).equals("数学与应用数学")){
			for (Double value: ScoreDao.mathCtypesMap.values()){
				sum+=value;
			}
		}
		else {
			for (Double value: ScoreDao.computingCtypesMap.values()){
				sum+=value;
			}
		}
		return credit>=Student.rankStandard*sum;
				
	}

}
