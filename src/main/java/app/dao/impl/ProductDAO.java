package app.dao.impl;

import java.util.List;

import app.dao.IProductDAO;
import app.mapper.CustomerMapper;
import app.mapper.EmployeeMapper;
import app.mapper.ProductMapper;
import app.model.EmployeeModel;
import app.model.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{

	@Override
	public List<ProductModel> findAll() {
		String sql = "select * from products";
		return query(sql, new ProductMapper());
	}

	@Override
	public ProductModel findOne(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from products where id = ?";
		List<ProductModel> productsModels = query(sql, new ProductMapper(), id);
		return productsModels.isEmpty() ? null : productsModels.get(0);
	}

	@Override
	public ProductModel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from products where name = ?";
		List<ProductModel> productsModels = query(sql, new ProductMapper(), name);
		return productsModels.isEmpty() ? null : productsModels.get(0);
	}

	@Override
	public int save(ProductModel productsModel) {
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
	public void update(ProductModel productsModel) {
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
