package app.dao;

import java.util.List;

import app.model.TransactionModel;

public interface ITransactionDAO extends GenericDAO<TransactionModel>{
	List<TransactionModel> findAll();
	TransactionModel findByCustomer(Integer id);
	TransactionModel findByEmployee(Integer id);
	int save(TransactionModel transactionsModel);
	void update(TransactionModel transactionsModel);
	void delete(int id);
	int getTotalItem();
}	
