package app.dao.impl;

import java.util.List;

import app.dao.ICategoryDAO;
import app.mapper.CategoryMapper;
import app.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from categorys";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(long id) {
		// TODO Auto-generated method stub
		String sql = "select * from categorys where id = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

	@Override
	public CategoryModel findOneByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from categorys where name = ?";
		List<CategoryModel> categoryModels = query(sql, new CategoryMapper(), name);
		return categoryModels.isEmpty() ? null : categoryModels.get(0);
	}

	@Override
	public int save(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return 0;
	}

	@Override
	public int update(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
