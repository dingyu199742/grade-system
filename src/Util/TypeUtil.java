package Util;



public class TypeUtil {
	public String getHanzifromType(String type){
			if (type.equals("PBC")){
				return "公共基础课";
			}
			if (type.equals("RSBC")){
				return "学科基础课(必修)";
			}
			if (type.equals("ESBC")){
				return "学科基础课(选修)";
			}
			if (type.equals("RPC")){
				return "专业知识课(必修)";
			}
			if (type.equals("EPC")){
				return "专业知识课(选修)";
			}
			if (type.equals("RJSC")){
				return "工作技能课(必修)";
			}
			if (type.equals("EJSC")){
				return "工作技能课(选修)";
			}
		return null;
	}

}
