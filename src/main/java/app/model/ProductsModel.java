package app.model;

import java.sql.Timestamp;

public class ProductsModel extends AbstactModel<ProductsModel>{
	private Integer idProvider;
	private Integer idEmployee;
	private String name;
	private Integer price;
	private Integer quantily;
	private String description;
	private Integer sale;
	private Timestamp createat;
	private Timestamp updateat;
	public Integer getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(Integer idProvider) {
		this.idProvider = idProvider;
	}
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantily() {
		return quantily;
	}
	public void setQuantily(Integer quantily) {
		this.quantily = quantily;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
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
}
