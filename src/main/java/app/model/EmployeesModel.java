package app.model;

import java.sql.Timestamp;

public class EmployeesModel extends AbstactModel<EmployeesModel>{
	private String name;
	private String phone;
	private Timestamp dateofbird;
	private String identification;
	private String address;
	private String username;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getDateofbird() {
		return dateofbird;
	}
	public void setDateofbird(Timestamp dateofbird) {
		this.dateofbird = dateofbird;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	private Integer level;
}
