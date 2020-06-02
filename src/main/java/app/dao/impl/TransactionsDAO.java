package app.dao.impl;

import java.util.List;

import app.dao.ITransactionsDAO;
import app.mapper.CustomersMapper;
import app.mapper.EmployeesMapper;
import app.mapper.TransactionsMapper;
import app.model.EmployeesModel;
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
		String sql = "select * from transactions where idCustomer = ?";
		List<TransactionsModel> transactionsModels = query(sql, new TransactionsMapper(), id);
		return transactionsModels.isEmpty() ? null : transactionsModels.get(0);
	}

	@Override
	public TransactionsModel findByEmployee(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from transactions where idEmployee = ?";
		List<TransactionsModel> transactionsModels = query(sql, new TransactionsMapper(), id);
		return transactionsModels.isEmpty() ? null : transactionsModels.get(0);

	}

	@Override
	public int save(TransactionsModel transactionsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO transactions (idCustomer, idEmployee)");
		sql.append(" VALUES(?, ?)");
		return insert(sql.toString(), 
				transactionsModel.getIdCustomer(), 
				transactionsModel.getIdEmployee());
	}

	@Override
	public void update(TransactionsModel transactionsModel) {
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
