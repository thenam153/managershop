package app.service;

import java.util.List;

import app.model.CustomersModel;

public interface ICustomersService {
	List<CustomersModel> findAll();
	CustomersModel findOne(int id);
}
