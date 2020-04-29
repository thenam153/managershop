package app.mapper;

import java.sql.ResultSet;

import app.model.CustomersModel;

public class CustomersMapper implements RowMapper<CustomersModel>{

	@Override
	public CustomersModel mapRow(ResultSet rs) {
		try {
			CustomersModel customer = new CustomersModel();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setDateofbirth(rs.getTimestamp("dateofbirth"));
			customer.setPhone(rs.getString("phone"));
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
}
