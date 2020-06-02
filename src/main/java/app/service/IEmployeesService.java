package app.service;

import java.util.List;

import app.model.EmployeesModel;

public interface IEmployeesService {
	List<EmployeesModel> findAll();
	EmployeesModel findOne(int id);
}
