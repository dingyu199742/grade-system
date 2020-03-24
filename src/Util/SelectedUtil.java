package Util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import dao.FieldDao;
import entity.Field;
import entity.Score;

public class SelectedUtil {
	public  Map <String, Score> selectScoreInOneCtypeFieldfromMap(String sfield, String ctype, Map <String, Score> map){
		LinkedHashMap <String, Score> map1=new LinkedHashMap <String, Score>();
		Field field=new Field();
		FieldDao fd=new FieldDao();
		for (Map.Entry<String, Score> entry : map.entrySet()){
			field =fd.findCtypeInFieldCode(entry.getValue().getCcode(), sfield);
			if (field.getCtype().equalsIgnoreCase(ctype)){
				map1.put(entry.getKey(), entry.getValue());
				
			}
		}
		return map1;
		
	}

}
