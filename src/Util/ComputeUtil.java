package Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

import dao.CourseDao;
import entity.Score;

public class ComputeUtil {
	//计算 map 中课程的 平均学分绩 
	public  double computingAvegrade(Map <String, Score> map){
		CourseDao cd=new CourseDao();
		double avegrade=0, creditSum=0;
		for (Map.Entry<String, Score> entry : map.entrySet()){
			creditSum += cd.findOneCourse(entry.getValue().getCcode()).getCredit();
			avegrade += cd.findOneCourse(entry.getValue().getCcode()).getCredit()*entry.getValue().getSgrade();
		}
		DecimalFormat formater = new DecimalFormat("#.###");
		formater.setRoundingMode(RoundingMode.FLOOR);
		avegrade = Double.valueOf(formater.format(avegrade/creditSum));
				
		return avegrade;
			
		}

}
