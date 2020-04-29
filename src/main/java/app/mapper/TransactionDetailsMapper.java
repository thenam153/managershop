package app.mapper;

import java.sql.ResultSet;

import app.model.TransactionsDetailsModel;

public class TransactionDetailsMapper implements RowMapper<TransactionsDetailsModel>{

	@Override
	public TransactionsDetailsModel mapRow(ResultSet rs) {
		try {
			TransactionsDetailsModel transaction = new TransactionsDetailsModel();
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
