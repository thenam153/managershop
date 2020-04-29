package app.model;

import java.sql.Timestamp;

public class CustomersModel extends AbstactModel<CustomersModel>{
	private String name;
	private Timestamp dateofbirth;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Timestamp dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
