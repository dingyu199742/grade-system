package test;

import java.util.Map;

import dao.CourseDao;
import dao.FieldDao;
import dao.ScoreDao;
import entity.Course;
import entity.Field;
import entity.Score;

public class CourseDaoTest {

	public static void main(String[] args) {
		//测试CourseDao findAllCourse()
//		CourseDao cd=new CourseDao();
//		Map<String, Course> map = cd.findAllCourse();
//		int count=0;
//		for (Course e : map.values()) {
//			count++;
//			System.out.println(e.getCcode()+"， " + e.getCname() + "， " + e.getCredit());
//			
//		}
//		System.out.println(count);
		//测试CourseDao findOneCourse()
		
		
		CourseDao cd=new CourseDao();
		String code="075303101275";
		Course course = cd.findOneCourse(code);
		System.out.println(course.getCname()+"，"+course.getCredit());
		
		
	}
}
	

