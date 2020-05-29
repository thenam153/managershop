package app.dao.impl;

import java.util.List;

import app.dao.IProvidersDAO;
import app.mapper.CustomersMapper;
import app.mapper.ProductsMapper;
import app.mapper.ProvidersMapper;
import app.model.ProductsModel;
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
		String sql = "select * from providers where id = ?";
		List<ProvidersModel> providersModels = query(sql, new ProvidersMapper(), id);
		return providersModels.isEmpty() ? null : providersModels.get(0);
	}

	@Override
	public ProvidersModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from providers where name = ?";
		List<ProvidersModel> providersModels = query(sql, new ProvidersMapper(), name);
		return providersModels.isEmpty() ? null : providersModels.get(0);
	}

	@Override
	public int save(ProvidersModel providersModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO providers (name, phone, address,");
		sql.append("status, description, idEmployee)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(),
				providersModel.getName(),
				providersModel.getPhone(),
				providersModel.getAddress(),
				providersModel.getStatus(),
				providersModel.getDescription(),
				providersModel.getIdEmployee());
	}

	@Override
	public void update(ProvidersModel providersModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE providers SET name = ?, phone = ?, address = ?,");
		sql.append("status = ?, description = ?, idEmployee = ? WHERE id = ?");
		update(sql.toString(),
				providersModel.getName(),
				providersModel.getPhone(),
				providersModel.getAddress(),
				providersModel.getStatus(),
				providersModel.getDescription(),
				providersModel.getIdEmployee(),
				providersModel.getId());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM providers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM providers";
		return count(sql);
	}
	
}
