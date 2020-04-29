package app.model;

import java.sql.Timestamp;

public class ProvidersModel extends AbstactModel<ProvidersModel>{
	private String name;
	private String phone;
	private String address;
	private String status;
	private String description;
	private Timestamp createat;
	private Timestamp updateat;
	private Integer idEmployee;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateat() {
		return createat;
	}
	public void setCreateat(Timestamp createat) {
		this.createat = createat;
	}
	public Timestamp getUpdateat() {
		return updateat;
	}
	public void setUpdateat(Timestamp updateat) {
		this.updateat = updateat;
	}
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	
}
