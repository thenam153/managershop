package app.dao;

import java.util.List;

import app.model.TransactionsDetailsModel;
import app.model.TransactionsModel;

public interface ITransactionsDetailsDAO extends GenericDAO<TransactionsDetailsModel>{
	List<TransactionsDetailsModel> findAll();
	TransactionsDetailsModel findByTransaction(Integer id);
	TransactionsDetailsModel findByProduct(Integer id);
	int save(TransactionsDetailsModel transactionsDetailsModel);
	void update(TransactionsDetailsModel transactionsDetailsModel);
	void delete(int id);
	int getTotalItem();
}
