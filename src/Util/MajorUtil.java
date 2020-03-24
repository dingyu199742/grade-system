package Util;

public class MajorUtil {
	// 根据学生的专业方向 判断 学生的专业
	public String getMajor(String field){
		if  (field.equalsIgnoreCase("应用数学")||field.equalsIgnoreCase("数理统计")){
			return "数学与应用数学";
						
		}else {
			return "信息与计算科学";
		}
	}
		

}
