package app.dao.impl;

import java.util.List;

import app.dao.IProviderDAO;
import app.mapper.CustomerMapper;
import app.mapper.ProductMapper;
import app.mapper.ProviderMapper;
import app.model.ProductModel;
import app.model.ProviderModel;

public class ProviderDAO extends AbstractDAO<ProviderModel> implements IProviderDAO{

	@Override
	public List<ProviderModel> findAll() {
		String sql = "select * from providers";
		return query(sql, new ProviderMapper());
	}

	@Override
	public ProviderModel findOne(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from providers where id = ?";
		List<ProviderModel> providersModels = query(sql, new ProviderMapper(), id);
		return providersModels.isEmpty() ? null : providersModels.get(0);
	}

	@Override
	public ProviderModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from providers where name = ?";
		List<ProviderModel> providersModels = query(sql, new ProviderMapper(), name);
		return providersModels.isEmpty() ? null : providersModels.get(0);
	}

	@Override
	public int save(ProviderModel providersModel) {
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
	public void update(ProviderModel providersModel) {
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
