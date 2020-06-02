package app.dao;

import java.util.List;

import app.model.EmployeesModel;

public interface IEmployeesDAO extends GenericDAO<EmployeesModel>{
	List<EmployeesModel> findAll();
	EmployeesModel findOne(Integer id);
	EmployeesModel findByName(String name);
	EmployeesModel findByUserName(String name);
	int save(EmployeesModel employeesModel);
	void update(EmployeesModel employeesModel);
	void delete(int id);
	int getTotalItem();
}
