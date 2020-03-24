package entity;

public class Field {
	private String ccode;
	private String ctype;
	private String field;
	
	public Field(){
		super();
		
	}
	public Field(String field, String ccode, String ctype){
		super();
		this.ccode=ccode;
		this.ctype=ctype;
		this.field=field;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
  
}
