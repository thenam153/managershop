package app.service;

import java.util.List;

import app.model.CategoryModel;


public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOne(int id);
}
