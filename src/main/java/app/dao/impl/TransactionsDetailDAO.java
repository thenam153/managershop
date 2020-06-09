package app.dao.impl;

import java.util.List;

import app.dao.ITransactionsDetailDAO;
import app.mapper.CustomerMapper;
import app.mapper.TransactionDetailMapper;
import app.mapper.TransactionMapper;
import app.model.TransactionsDetailModel;
import app.model.TransactionModel;

public class TransactionsDetailDAO extends AbstractDAO<TransactionsDetailModel> implements ITransactionsDetailDAO{

	@Override
	public List<TransactionsDetailModel> findAll() {
		String sql = "select * from transactiondetails";
		return query(sql, new TransactionDetailMapper());
	}

	@Override
	public TransactionsDetailModel findByTransaction(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from transactionsdetails where idTransaction = ?";
		List<TransactionsDetailModel> transactionsDetailsModels = query(sql, new TransactionDetailMapper(), id);
		return transactionsDetailsModels.isEmpty() ? null : transactionsDetailsModels.get(0);
	}

	@Override
	public TransactionsDetailModel findByProduct(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from transactionsdetails where idProduct = ?";
		List<TransactionsDetailModel> transactionsDetailsModels = query(sql, new TransactionDetailMapper(), id);
		return transactionsDetailsModels.isEmpty() ? null : transactionsDetailsModels.get(0);
	}

	@Override
	public int save(TransactionsDetailModel transactionsDetailsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO transactiondetails (idTransaction, idProduct, ");
		sql.append("quantily, price, total)");
		sql.append(" VALUES(?, ?, ?, ?, ?)");
		return insert(sql.toString(), 
				transactionsDetailsModel.getIdTransaction(), 
				transactionsDetailsModel.getIdProduct(),
				transactionsDetailsModel.getQuantily(),
				transactionsDetailsModel.getPrice(),
				transactionsDetailsModel.getTotal());
	}

	@Override
	public void update(TransactionsDetailModel transactionsDetailsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE transactiondetails SET idTransaction = ?, idProduct = ?, ");
		sql.append("quantily = ?, price = ?, total = ? ");
		sql.append("WHERE id = ?");
		update(sql.toString(), 
				transactionsDetailsModel.getIdTransaction(), 
				transactionsDetailsModel.getIdProduct(),
				transactionsDetailsModel.getQuantily(),
				transactionsDetailsModel.getPrice(),
				transactionsDetailsModel.getTotal(),
				transactionsDetailsModel.getId());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM transactionsdetails WHERE id = ?";
		update(sql, id);

	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM transactionsdetails";
		return count(sql);
	}

}
