package app.dao;

import java.util.List;

import app.model.ProductModel;

public interface IProductDAO extends GenericDAO<ProductModel>{
	List<ProductModel> findAll();
	ProductModel findOne(Integer id);
	ProductModel findByName(String name);
	int save(ProductModel productsModel);
	void update(ProductModel productsModel);
	void delete(int id);
	int getTotalItem();
}
