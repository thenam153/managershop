package app.dao.impl;

import java.util.List;

import app.dao.IEmployeesDAO;
import app.mapper.CustomersMapper;
import app.mapper.EmployeesMapper;
import app.model.CustomersModel;
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
		String sql = "select * from employees where id = ?";
		List<EmployeesModel> employeesModels = query(sql, new EmployeesMapper(), id);
		return employeesModels.isEmpty() ? null : employeesModels.get(0);
	}

	@Override
	public EmployeesModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from employees where name = ?";
		List<EmployeesModel> employeesModels = query(sql, new EmployeesMapper(), name);
		return employeesModels.isEmpty() ? null : employeesModels.get(0);
	}

	@Override
	public int save(EmployeesModel employeesModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO employees (name, phone, dateofbirth,");
		sql.append("identification, address, username, password, level)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), 
				employeesModel.getName(), 
				employeesModel.getPhone(), 
				employeesModel.getDateofbird(), 
				employeesModel.getIdentification(),
				employeesModel.getAddress(), 
				employeesModel.getUsername(), 
				employeesModel.getPassword(), 
				employeesModel.getLevel());
	}

	@Override
	public void update(EmployeesModel employeesModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE employees SET name = ?, phone = ?, dateofbirth = ?,");
		sql.append("identification = ?, address = ?, username = ?, password = ?, level = ? WHERE id = ?");
		update(sql.toString(), employeesModel.getName(),
				employeesModel.getPhone(),
				employeesModel.getDateofbird(),
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
	
}
