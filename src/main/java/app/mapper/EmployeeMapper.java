package app.mapper;

import java.sql.ResultSet;

import app.model.EmployeeModel;

public class EmployeeMapper implements RowMapper<EmployeeModel>{

	@Override
	public EmployeeModel mapRow(ResultSet rs) {
		try {
			EmployeeModel employee = new EmployeeModel();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setPhone(rs.getString("phone"));
			employee.setIdentification(rs.getString("identification"));
			employee.setAddress(rs.getString("address"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setLevel(rs.getInt("level"));
			employee.setDateofbirth(rs.getString("dateofbirth"));
			return employee;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
