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

	@Override
	public int save(TransactionsDetailsModel transactionsDetailsModel) {
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
	public void update(TransactionsDetailsModel transactionsDetailsModel) {
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
