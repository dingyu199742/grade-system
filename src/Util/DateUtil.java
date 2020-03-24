package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	public String getStringfromDate(String geShi, Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(geShi);
		return sdf.format(date);
	}
	public Date getDatefromString(String geShi, String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(geShi);
		return sdf.parse(date);
	}
	
}
