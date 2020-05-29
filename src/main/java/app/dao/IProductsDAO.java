package app.dao;

import java.util.List;

import app.model.ProductsModel;

public interface IProductsDAO extends GenericDAO<ProductsModel>{
	List<ProductsModel> findAll();
	ProductsModel findOne(Integer id);
	ProductsModel findByName(String name);
	int save(ProductsModel productsModel);
	void update(ProductsModel productsModel);
	void delete(int id);
	int getTotalItem();
}
