package entity;

public class Student {
	private String  sid;
	private String  sname;
	private double avegrade;
	private String major;
	private String  sfield;
	private String  sclass;
	private int isRanked;
	private String  password;
	public static double rankStandard=0.75;
	
	public Student(){
		super();
	}   
	
	public Student(String sid, String sname, int isRanked,String password) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.isRanked=isRanked;
		this.password = password;
	}

	public Student(String sid, String sname, double avegrade, String major,
			String sfield, String sclass, int isRanked, String password) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.avegrade = avegrade;
		this.major = major;
		this.sfield = sfield;
		this.sclass = sclass;
		this.isRanked = isRanked;
		this.password = password;
	}
	
	
	public Student(String sid, String sname, double avegrade, String major,
			String sfield, String sclass) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.avegrade = avegrade;
		this.major = major;
		this.sfield = sfield;
		this.sclass = sclass;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getSfield() {
		return sfield;
	}

	public void setSfield(String sfield) {
		this.sfield = sfield;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public double getAvegrade() {
		return avegrade;
	}

	public void setAvegrade(double avegrade) {
		this.avegrade = avegrade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getIsRanked() {
		return isRanked;
	}

	public void setIsRanked(int isRanked) {
		this.isRanked = isRanked;
	}


}
