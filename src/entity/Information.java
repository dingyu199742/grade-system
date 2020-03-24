package entity;

public class Information {
	private String longText;
	private String biaoqian;
	private String fileName;
	private String filePath;
	private String time;
	
	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Information(String longText, String biaoqian, String fileName,
			String filePath, String time) {
		super();
		this.longText = longText;
		this.biaoqian = biaoqian;
		this.fileName = fileName;
		this.filePath = filePath;
		this.time = time;
	}


	public String getLongText() {
		return longText;
	}


	public void setLongText(String longText) {
		this.longText = longText;
	}


	public String getBiaoqian() {
		return biaoqian;
	}


	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	

	

}
