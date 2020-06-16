package app.dao.impl;

import java.util.List;

import app.dao.ICustomerDAO;
import app.mapper.CustomerMapper;
import app.model.CustomerModel;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO{

	@Override
	public List<CustomerModel> findAll() {
		String sql = "select * from customers";
		return query(sql, new CustomerMapper());
	}

	@Override
	public CustomerModel findOne(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from customers where id = ?";
		List<CustomerModel> customersModels = query(sql, new CustomerMapper(), id);
		return customersModels.isEmpty() ? null : customersModels.get(0);
	}

	@Override
	public CustomerModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from customers where name = ?";
		List<CustomerModel> customersModels = query(sql, new CustomerMapper(), name);
		return customersModels.isEmpty() ? null : customersModels.get(0);
	}

	@Override
	public int save(CustomerModel customersModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO customers (name, dateofbirth, phone)");
		sql.append(" VALUES(?, ?, ?)");
		return insert(sql.toString(), customersModel.getName(), customersModel.getDateofbirth(), 
				customersModel.getPhone());
	}

	@Override
	public void update(CustomerModel customersModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE customers SET name = ?, dateofbirth = ?, phone = ?");
		sql.append("WHERE id = ?");
		update(sql.toString(), customersModel.getName(), customersModel.getDateofbirth(), customersModel.getPhone(), customersModel.getId());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM customers";
		return count(sql);
	}

}
