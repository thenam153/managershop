package app.dao.impl;

import java.util.List;

import app.dao.ITransactionsDAO;
import app.mapper.CustomersMapper;
import app.mapper.TransactionsMapper;
import app.model.TransactionsModel;

public class TransactionsDAO extends AbstractDAO<TransactionsModel> implements ITransactionsDAO{

	@Override
	public List<TransactionsModel> findAll() {
		String sql = "select * from transactions";
		return query(sql, new TransactionsMapper());
	}

	@Override
	public TransactionsModel findByCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionsModel findByEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
