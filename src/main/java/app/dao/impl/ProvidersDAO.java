package app.dao.impl;

import java.util.List;

import app.dao.IProvidersDAO;
import app.mapper.CustomersMapper;
import app.mapper.ProvidersMapper;
import app.model.ProvidersModel;

public class ProvidersDAO extends AbstractDAO<ProvidersModel> implements IProvidersDAO{

	@Override
	public List<ProvidersModel> findAll() {
		String sql = "select * from providers";
		return query(sql, new ProvidersMapper());
	}

	@Override
	public ProvidersModel findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProvidersModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
