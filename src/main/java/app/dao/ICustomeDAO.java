package app.dao;

import java.util.List;

import app.model.CustomerModel;

public interface ICustomeDAO extends GenericDAO<CustomerModel>{
	List<CustomerModel> findAll();
	CustomerModel findOne(Integer id);
	CustomerModel findByName(String name);
	int save(CustomerModel customersModel);
	void update(CustomerModel customersModel);
	void delete(int id);
	int getTotalItem();
}
