package app.dao.impl;

import java.util.List;

import app.dao.IProductsDAO;
import app.mapper.CustomersMapper;
import app.mapper.EmployeesMapper;
import app.mapper.ProductsMapper;
import app.model.EmployeesModel;
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
		String sql = "select * from products where id = ?";
		List<ProductsModel> productsModels = query(sql, new ProductsMapper(), id);
		return productsModels.isEmpty() ? null : productsModels.get(0);
	}

	@Override
	public ProductsModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from products where name = ?";
		List<ProductsModel> productsModels = query(sql, new ProductsMapper(), name);
		return productsModels.isEmpty() ? null : productsModels.get(0);
	}

	@Override
	public int save(ProductsModel productsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO products (idProvider, idEmployee, name,");
		sql.append("price, quantily, description, sale)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), productsModel.getIdProvider(),
				productsModel.getIdEmployee(),
				productsModel.getName(),
				productsModel.getPrice(),
				productsModel.getQuantily(),
				productsModel.getDescription(),
				productsModel.getSale());
	}

	@Override
	public void update(ProductsModel productsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE products SET idProvider = ?, idEmployee = ?, name = ?,");
		sql.append("price = ?, quantily = ?, description = ?, sale = ? WHERE id = ?");
		update(sql.toString(), productsModel.getIdProvider(),
				productsModel.getIdEmployee(),
				productsModel.getName(),
				productsModel.getPrice(),
				productsModel.getQuantily(),
				productsModel.getDescription(),
				productsModel.getSale(),
				productsModel.getId());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM products WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM products";
		return count(sql);
	}

}
