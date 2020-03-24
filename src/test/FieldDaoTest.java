package test;

import java.util.Map;

import dao.CourseDao;
import dao.FieldDao;
import entity.Field;

public class FieldDaoTest {

	public static void main(String[] args) {
		//测试FieldDao    findOneField()
		
//		FieldDao fd=new FieldDao();
//		CourseDao cd=new CourseDao();
//		Map<String, Field> map = fd.findOneField("应用数学");
//		int count=0;
//		for (Field e : map.values()) {
//			count++;
//			
//			//System.out.println(e.getField()+"， " + e.getCtype()+ "， " + e.getCcode());
//			System.out.println(e.getField()+"， " + e.getCtype()+ "， " + e.getCcode()+","+cd.findOneCourse(e.getCcode()).getCname());
//
//		}
//		System.out.println(count);
		
		//测试FieldDao    findCtypeInFieldCode()
		/*
		FieldDao fd=new FieldDao();
		Field field=fd.findCtypeInFieldCode("075113101223", "probability");
		System.out.println(field.getField()+"，"+field.getCtype()+"，"+field.getCcode());
		*/
		
		//测试FieldDao    findCcodeInFieldCtype
		/*
		FieldDao fd=new FieldDao();
		Map<String, Field> map =fd.findCcodeInFieldCtype("M_RPC", "math");
		for (Field e : map.values()) {
			System.out.println(e.getCcode()+"， " + e.getCtype());

		}
		*/
//		Field infofield=new Field("信息科学", "008101101019", "EPC");
//		FieldDao fd=new FieldDao();
//		fd.updateCtypeInFieldCode(infofield);
	}

}
