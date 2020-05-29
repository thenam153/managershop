package app.dao;

import java.util.List;

import app.model.TransactionsModel;

public interface ITransactionsDAO extends GenericDAO<TransactionsModel>{
	List<TransactionsModel> findAll();
	TransactionsModel findByCustomer(Integer id);
	TransactionsModel findByEmployee(Integer id);
	int save(TransactionsModel transactionsModel);
	void update(TransactionsModel transactionsModel);
	void delete(int id);
	int getTotalItem();
}	
