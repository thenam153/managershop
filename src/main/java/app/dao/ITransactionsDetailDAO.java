package app.dao;

import java.util.List;

import app.model.TransactionsDetailModel;
import app.model.TransactionModel;

public interface ITransactionsDetailDAO extends GenericDAO<TransactionsDetailModel>{
	List<TransactionsDetailModel> findAll();
	TransactionsDetailModel findByTransaction(Integer id);
	TransactionsDetailModel findByProduct(Integer id);
	int save(TransactionsDetailModel transactionsDetailsModel);
	void update(TransactionsDetailModel transactionsDetailsModel);
	void delete(int id);
	int getTotalItem();
}
