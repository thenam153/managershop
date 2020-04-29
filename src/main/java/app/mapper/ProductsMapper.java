package app.mapper;

import java.sql.ResultSet;

import app.model.ProductsModel;

public class ProductsMapper implements RowMapper<ProductsModel>{

	@Override
	public ProductsModel mapRow(ResultSet rs) {
		try {
			ProductsModel product = new ProductsModel();
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
