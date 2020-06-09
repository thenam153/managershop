package app.mapper;

import java.sql.ResultSet;

import app.model.TransactionsDetailModel;

public class TransactionDetailMapper implements RowMapper<TransactionsDetailModel>{

	@Override
	public TransactionsDetailModel mapRow(ResultSet rs) {
		try {
			TransactionsDetailModel transaction = new TransactionsDetailModel();
			transaction.setId(rs.getInt("id"));
			transaction.setIdTransaction(rs.getInt("idTransaction"));
			transaction.setIdProduct(rs.getInt("idProduct"));
			transaction.setQuantily(rs.getInt("quantily"));
			transaction.setPrice(rs.getInt("price"));
			transaction.setTotal(rs.getInt("total"));
			transaction.setCreateat(rs.getTimestamp("createat"));
			return transaction;
		} catch (Exception e) {			
			return null;
		}
	}

}
