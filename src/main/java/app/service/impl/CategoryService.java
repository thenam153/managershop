package app.service.impl;

import java.util.List;

import javax.inject.Inject;

import app.dao.ICategoryDAO;
import app.dao.impl.CategoryDAO;
import app.model.CategoryModel;
import app.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private CategoryDAO categoryDao = new CategoryDAO();
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}
	@Override
	public CategoryModel findOne(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}
	@Override
	public CategoryModel findOne(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}
	
}
