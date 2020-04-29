package app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setContent(rs.getString("content"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}

}
