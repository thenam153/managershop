package app.mapper;

import java.sql.ResultSet;

import app.model.TransactionsModel;

public class TransactionsMapper implements RowMapper<TransactionsModel>{

	@Override
	public TransactionsModel mapRow(ResultSet rs) {
		try {
			TransactionsModel transaction = new TransactionsModel();
			transaction.setId(rs.getInt("id"));
			transaction.setIdCustomer(rs.getInt("idEmployee"));
			transaction.setCreateat(rs.getTimestamp("createat"));
			return transaction;
		} catch (Exception e) {		
			return null;
		}
	}

}
