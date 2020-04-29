package app.dao;

import java.util.List;

import app.model.CustomersModel;

public interface ICustomesDAO extends GenericDAO<CustomersModel>{
	List<CustomersModel> findAll();
	CustomersModel findOne(Integer id);
	CustomersModel findByName(String name);
}
