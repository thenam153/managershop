package app.mapper;

import java.sql.ResultSet;

import app.model.TransactionModel;

public class TransactionMapper implements RowMapper<TransactionModel>{

	@Override
	public TransactionModel mapRow(ResultSet rs) {
		try {
			TransactionModel transaction = new TransactionModel();
			transaction.setId(rs.getInt("id"));
			transaction.setIdCustomer(rs.getInt("idCustomer"));
			transaction.setIdEmployee(rs.getInt("idEmployee"));
			transaction.setCreateat(rs.getTimestamp("createat"));
			return transaction;
		} catch (Exception e) {		
			return null;
		}
	}

}
