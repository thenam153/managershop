package app.mapper;

import java.sql.ResultSet;

import app.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel>{

	@Override
	public ProductModel mapRow(ResultSet rs) {
		try {
			ProductModel product = new ProductModel();
			product.setId(rs.getInt("id"));
			product.setIdProvider(rs.getInt("idProvider"));
			product.setIdEmployee(rs.getInt("idEmployee"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setQuantily(rs.getInt("quantily"));
			product.setDescription(rs.getString("description"));
			product.setSale(rs.getInt("sale"));
			product.setCreateat(rs.getTimestamp("createat"));
			product.setUpdateat(rs.getTimestamp("updateat"));
			return product;
		} catch (Exception e) {
			return null;
		}
	}

}
