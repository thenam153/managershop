package app.service;

import java.util.List;

import app.model.ProductsModel;

public interface IProductsService {
	List<ProductsModel> findAll();
	ProductsModel findOne(int id);
}
