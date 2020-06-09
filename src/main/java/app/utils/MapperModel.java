package app.utils;

import java.util.List;

import app.model.CustomerModel;
import app.model.ProductModel;
import app.model.TransactionsDetailModel;
import app.model.TransactionModel;

public class MapperModel {
	List<TransactionsDetailModel> transactionsDetailsModels;
	List<TransactionModel> transactionsModels;
	List<ProductModel> productsModels;
	List<CustomerModel> customersModels;
	public MapperModel(List<TransactionsDetailModel> a, List<TransactionModel> b, List<ProductModel> c, List<CustomerModel> d) {
		// TODO Auto-generated constructor stub
		transactionsDetailsModels = a;
		transactionsModels = b;
		productsModels = c;
		customersModels = d;
	}
	
}
