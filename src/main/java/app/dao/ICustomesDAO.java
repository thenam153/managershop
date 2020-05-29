package app.dao;

import java.util.List;

import app.model.CustomersModel;

public interface ICustomesDAO extends GenericDAO<CustomersModel>{
	List<CustomersModel> findAll();
	CustomersModel findOne(Integer id);
	CustomersModel findByName(String name);
	int save(CustomersModel customersModel);
	void update(CustomersModel customersModel);
	void delete(int id);
	int getTotalItem();
}
