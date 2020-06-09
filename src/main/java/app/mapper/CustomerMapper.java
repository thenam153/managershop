package app.mapper;

import java.sql.ResultSet;

import app.model.CustomerModel;

public class CustomerMapper implements RowMapper<CustomerModel>{

	@Override
	public CustomerModel mapRow(ResultSet rs) {
		try {
			CustomerModel customer = new CustomerModel();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setDateofbirth(rs.getString("dateofbirth"));
			customer.setPhone(rs.getString("phone"));
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
}
