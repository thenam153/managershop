package app.dao.impl;

import java.util.List;

import app.dao.IEmployeeDAO;
import app.mapper.CustomerMapper;
import app.mapper.EmployeeMapper;
import app.model.CustomerModel;
import app.model.EmployeeModel;

public class EmployeeDAO extends AbstractDAO<EmployeeModel> implements IEmployeeDAO{

	@Override
	public List<EmployeeModel> findAll() {
		String sql = "select * from employees";
		return query(sql, new EmployeeMapper());
	}

	@Override
	public EmployeeModel findOne(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from employees where id = ?";
		List<EmployeeModel> employeesModels = query(sql, new EmployeeMapper(), id);
		return employeesModels.isEmpty() ? null : employeesModels.get(0);
	}

	@Override
	public EmployeeModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from employees where name = ?";
		List<EmployeeModel> employeesModels = query(sql, new EmployeeMapper(), name);
		return employeesModels.isEmpty() ? null : employeesModels.get(0);
	}

	@Override
	public int save(EmployeeModel employeesModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO employees (name, phone, dateofbirth,");
		sql.append("identification, address, username, password, level)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), 
				employeesModel.getName(), 
				employeesModel.getPhone(), 
				employeesModel.getDateofbirth(), 
				employeesModel.getIdentification(),
				employeesModel.getAddress(), 
				employeesModel.getUsername(), 
				employeesModel.getPassword(), 
				employeesModel.getLevel());
	}

	@Override
	public void update(EmployeeModel employeesModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE employees SET name = ?, phone = ?, dateofbirth = ?,");
		sql.append("identification = ?, address = ?, username = ?, password = ?, level = ? WHERE id = ?");
		update(sql.toString(), employeesModel.getName(),
				employeesModel.getPhone(),
				employeesModel.getDateofbirth(),
				employeesModel.getIdentification(),
				employeesModel.getAddress(),
				employeesModel.getUsername(),
				employeesModel.getPassword(),
				employeesModel.getLevel(),
				employeesModel.getId());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM employees WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM employees";
		return count(sql);
	}

	@Override
	public EmployeeModel findByUserName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from employees where username = ?";
		List<EmployeeModel> employeesModels = query(sql, new EmployeeMapper(), name);
		System.out.println(employeesModels);
		return employeesModels.isEmpty() ? null : employeesModels.get(0);
	}
	
}
