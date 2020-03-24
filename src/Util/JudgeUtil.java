package Util;


import java.util.Arrays;

import dao.CourseDao;
import dao.FieldDao;
import dao.ScoreDao;
import entity.Student;

public class JudgeUtil {
	//(除应数的专业知识选修的判断)
	MajorUtil mu=new MajorUtil();
	CourseDao cd=new CourseDao();
	ScoreDao sd=new ScoreDao();
	FieldDao fd=new FieldDao();
	public boolean judgeNonstandard(String[] codes, String ctype, Student stu){
		double limit, sum=0, choice=0;
		double[] credits = new double[50];
		
		
		if (mu.getMajor(stu.getSfield()).equals("数学与应用数学")){
			limit=ScoreDao.mathCtypesMap.get(ctype);
		}else if(ctype.equals("ESBC")){
			return false;
		}else{
			
			limit=ScoreDao.computingCtypesMap.get(ctype);	
		}
		for (int i=0; i<codes.length; i++){
			if (cd.findOneCourse(codes[i])!=null){
				credits[i]=cd.findOneCourse(codes[i]).getCredit();
			}
		}
		Arrays.sort(credits);
		for (int i=0; i<credits.length; i++){
			sum+=credits[i];
			if (sum>=limit){
				choice++;
			}
			
		}
		if (!sd.isQualified(stu.getSid(), ctype)){
			return false;
		}
		
		if (choice!=1){
			return true;
		}else {
			return false;
		}
	}
	//(应数四选二 EPC1 课程)
	public boolean judgeNonstandardinEPC1(String[] codes, Student stu){
		if (mu.getMajor(stu.getSfield()).equals("信息与计算科学")){
			return false;
		}
		
		if (codes.length < 2){
			return true;
		}
		if (!sd.isQualifiedInMathEPC1(stu.getSid(), "EPC1", 2)){
			return false;
		}
		return false;
			
		
	}
	//（应数其他 参数为EPC1和EPC2的课）
	public boolean judgeNonstandardinEPC2(String[] codes, Student stu){
		if (mu.getMajor(stu.getSfield()).equals("信息与计算科学")){
			return false;
		}
		double[] credits = new double[50], creditsEPC2 = new double[50];
		
		
		double sum=0 ;
		int count1=0, count2=0, choice=0;
		
		for (int i=0; i<codes.length; i++){
			if (cd.findOneCourse(codes[i])!=null){
				
				credits[i]=cd.findOneCourse(codes[i]).getCredit();
				
				if (fd.findCtypeInFieldCode(codes[i], stu.getSfield()).getCtype().equals("EPC1")){
					count1++;
					if (count1 > 2){
						creditsEPC2[count2]=credits[i];
						count2++;
					}
				}
				
				if (fd.findCtypeInFieldCode(codes[i], stu.getSfield()).getCtype().equals("EPC2")){
					creditsEPC2[count2]=credits[i];
					
					count2++;
				}
			}
		}
		Arrays.sort(creditsEPC2);
		for (int i=0; i<creditsEPC2.length; i++){
			sum+=creditsEPC2[i];
			System.out.println("--------------");
			System.out.println(creditsEPC2[i]);
			if (sum>=12){
				choice++;
			}
		}
		System.out.println(choice);
		if (!sd.isQualifiedInMathEPC2(stu.getSid())){
			return false;
		}
		if (choice!=1){
			return true;
		}
		
		return false;
		
			
		
	}

}
