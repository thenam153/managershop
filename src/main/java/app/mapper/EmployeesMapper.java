package app.mapper;

import java.sql.ResultSet;

import app.model.EmployeesModel;

public class EmployeesMapper implements RowMapper<EmployeesModel>{

	@Override
	public EmployeesModel mapRow(ResultSet rs) {
		try {
			EmployeesModel employee = new EmployeesModel();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setPhone(rs.getString("phone"));
			employee.setIdentification(rs.getString("identification"));
			employee.setAddress(rs.getString("address"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setLevel(rs.getInt("level"));
			return employee;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
