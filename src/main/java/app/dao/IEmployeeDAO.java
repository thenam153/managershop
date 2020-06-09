package app.dao;

import java.util.List;

import app.model.EmployeeModel;

public interface IEmployeeDAO extends GenericDAO<EmployeeModel>{
	List<EmployeeModel> findAll();
	EmployeeModel findOne(Integer id);
	EmployeeModel findByName(String name);
	EmployeeModel findByUserName(String name);
	int save(EmployeeModel employeesModel);
	void update(EmployeeModel employeesModel);
	void delete(int id);
	int getTotalItem();
}
