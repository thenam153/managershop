package app.dao.impl;

import java.util.List;

import app.dao.ITransactionsDetailsDAO;
import app.mapper.CustomersMapper;
import app.mapper.TransactionDetailsMapper;
import app.model.TransactionsDetailsModel;

public class TransactionsDetailsDAO extends AbstractDAO<TransactionsDetailsModel> implements ITransactionsDetailsDAO{

	@Override
	public List<TransactionsDetailsModel> findAll() {
		String sql = "select * from transactionsdetails";
		return query(sql, new TransactionDetailsMapper());
	}

	@Override
	public TransactionsDetailsModel findByTransaction(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionsDetailsModel findByProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
