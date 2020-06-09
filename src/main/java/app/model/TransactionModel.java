package app.model;

import java.sql.Timestamp;

public class TransactionModel extends AbstactModel<TransactionModel>{
	private Integer idCustomer;
	private Integer idEmployee;
	private Timestamp createat;
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	public Timestamp getCreateat() {
		return createat;
	}
	public void setCreateat(Timestamp createat) {
		this.createat = createat;
	}
	
}
