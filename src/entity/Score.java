package entity;

public class Score {
	private String sid;
	private String ccode;
	private double sgrade;
	private String state;
	private int term;
	private int isSelected;
    
    public Score(){
    	super();
    }
    
	public Score(String sid, String ccode) {
		super();
		this.sid = sid;
		this.ccode = ccode;
	}

	public Score(String sid, String ccode, double sgrade, String state,
			int term, int isSelected) {
		super();
		this.sid = sid;
		this.ccode = ccode;
		this.sgrade = sgrade;
		this.state = state;
		this.term = term;
		this.isSelected = isSelected;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public double getSgrade() {
		return sgrade;
	}

	public void setSgrade(double sgrade) {
		this.sgrade = sgrade;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getTerm() {
		return term;
	}

	public int getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}
	
    
}
