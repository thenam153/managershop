package app.dao.impl;

import java.util.List;

import app.dao.IProductsDAO;
import app.mapper.CustomersMapper;
import app.mapper.ProductsMapper;
import app.model.ProductsModel;

public class ProductsDAO extends AbstractDAO<ProductsModel> implements IProductsDAO{

	@Override
	public List<ProductsModel> findAll() {
		String sql = "select * from products";
		return query(sql, new ProductsMapper());
	}

	@Override
	public ProductsModel findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
