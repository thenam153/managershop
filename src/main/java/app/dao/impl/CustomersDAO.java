package app.dao.impl;

import java.util.List;

import app.dao.ICustomesDAO;
import app.mapper.CategoryMapper;
import app.mapper.CustomersMapper;
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
		return null;
	}

	@Override
	public CustomersModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
