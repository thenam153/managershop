package app.dao.impl;

import java.util.List;

import app.dao.IEmployeesDAO;
import app.mapper.CustomersMapper;
import app.mapper.EmployeesMapper;
import app.model.EmployeesModel;

public class EmployeesDAO extends AbstractDAO<EmployeesModel> implements IEmployeesDAO{

	@Override
	public List<EmployeesModel> findAll() {
		String sql = "select * from employees";
		return query(sql, new EmployeesMapper());
	}

	@Override
	public EmployeesModel findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeesModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
