package app.dao;

import java.util.List;

import app.model.TransactionsDetailsModel;

public interface ITransactionsDetailsDAO extends GenericDAO<TransactionsDetailsModel>{
	List<TransactionsDetailsModel> findAll();
	TransactionsDetailsModel findByTransaction(Integer id);
	TransactionsDetailsModel findByProduct(Integer id);
}
