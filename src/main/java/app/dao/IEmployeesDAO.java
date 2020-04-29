package app.dao;

import java.util.List;

import app.model.EmployeesModel;

public interface IEmployeesDAO extends GenericDAO<EmployeesModel>{
	List<EmployeesModel> findAll();
	EmployeesModel findOne(Integer id);
	EmployeesModel findByName(String name);
	
}
