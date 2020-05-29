package app.dao.impl;

import java.util.List;

import app.dao.ICustomesDAO;
import app.mapper.CategoryMapper;
import app.mapper.CustomersMapper;
import app.model.CategoryModel;
import app.model.CustomersModel;

public class CustomersDAO extends AbstractDAO<CustomersModel> implements ICustomesDAO{

	@Override
	public List<CustomersModel> findAll() {
		String sql = "select * from customers";
		return query(sql, new CustomersMapper());
	}

	@Override
	public CustomersModel findOne(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from customers where id = ?";
		List<CustomersModel> customersModels = query(sql, new CustomersMapper(), id);
		return customersModels.isEmpty() ? null : customersModels.get(0);
	}

	@Override
	public CustomersModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from customers where name = ?";
		List<CustomersModel> customersModels = query(sql, new CustomersMapper(), name);
		return customersModels.isEmpty() ? null : customersModels.get(0);
	}

	@Override
	public int save(CustomersModel customersModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO customers (name, dateofbirth, phone)");
		sql.append(" VALUES(?, ?, ?)");
		return insert(sql.toString(), customersModel.getName(), customersModel.getDateofbirth(), 
				customersModel.getPhone());
	}

	@Override
	public void update(CustomersModel customersModel) {
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
