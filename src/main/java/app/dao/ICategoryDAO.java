package app.dao;

import java.util.List;

import app.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
	CategoryModel findOneByName(String name);
	int save(CategoryModel categoryModel);
	int update(CategoryModel categoryModel);
	void delete(int id);
	int getTotalItem();
}
