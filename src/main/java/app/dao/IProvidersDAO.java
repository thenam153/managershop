package app.dao;

import java.util.List;

import app.model.ProvidersModel;

public interface IProvidersDAO extends GenericDAO<ProvidersModel>{
	List<ProvidersModel> findAll();
	ProvidersModel findOne(Integer id);
	ProvidersModel findByName(String name);
	int save(ProvidersModel providersModel);
	void update(ProvidersModel providersModel);
	void delete(int id);
	int getTotalItem();
}
