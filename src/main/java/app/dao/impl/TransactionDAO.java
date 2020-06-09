package app.dao.impl;

import java.util.List;

import app.dao.ITransactionDAO;
import app.mapper.CustomerMapper;
import app.mapper.EmployeeMapper;
import app.mapper.TransactionMapper;
import app.model.EmployeeModel;
import app.model.TransactionModel;

public class TransactionDAO extends AbstractDAO<TransactionModel> implements ITransactionDAO{

	@Override
	public List<TransactionModel> findAll() {
		String sql = "select * from transactions";
		return query(sql, new TransactionMapper());
	}

	@Override
	public TransactionModel findByCustomer(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from transactions where idCustomer = ?";
		List<TransactionModel> transactionsModels = query(sql, new TransactionMapper(), id);
		return transactionsModels.isEmpty() ? null : transactionsModels.get(0);
	}

	@Override
	public TransactionModel findByEmployee(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from transactions where idEmployee = ?";
		List<TransactionModel> transactionsModels = query(sql, new TransactionMapper(), id);
		return transactionsModels.isEmpty() ? null : transactionsModels.get(0);

	}

	@Override
	public int save(TransactionModel transactionsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO transactions (idCustomer, idEmployee)");
		sql.append(" VALUES(?, ?)");
		return insert(sql.toString(), 
				transactionsModel.getIdCustomer(), 
				transactionsModel.getIdEmployee());
	}

	@Override
	public void update(TransactionModel transactionsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE transactions SET idCustomer = ?, idEmployee = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), 
				transactionsModel.getIdCustomer(), 
				transactionsModel.getIdEmployee());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM transactions WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM transactions";
		return count(sql);
	}

}
