package app.dao;

import java.util.List;

import app.model.ProviderModel;

public interface IProviderDAO extends GenericDAO<ProviderModel>{
	List<ProviderModel> findAll();
	ProviderModel findOne(Integer id);
	ProviderModel findByName(String name);
	int save(ProviderModel providersModel);
	void update(ProviderModel providersModel);
	void delete(int id);
	int getTotalItem();
}
