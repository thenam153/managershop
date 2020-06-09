package app.model;

import java.sql.Timestamp;

public class TransactionsDetailModel extends AbstactModel<TransactionsDetailModel>{
	private Integer idTransaction;
	private Integer idProduct;
	private Integer quantily;
	private Integer price;
	private Integer total;
	private Timestamp createat;
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getQuantily() {
		return quantily;
	}
	public void setQuantily(Integer quantily) {
		this.quantily = quantily;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Timestamp getCreateat() {
		return createat;
	}
	public void setCreateat(Timestamp createat) {
		this.createat = createat;
	}
}
