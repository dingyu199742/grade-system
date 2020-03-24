package entity;

public class Course {
	private String ccode;
	private String cname;
	private double credit;
	private String oldCode;
	
	public Course() {
		super();
	}
	public Course(String ccode, String cname, double credit, String oldCode) {
		super();
		this.ccode = ccode;
		this.cname = cname;
		this.credit = credit;
		this.oldCode= oldCode;
	}
	
	public String getCcode() {
		return ccode;
	}
	
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	
}
