package app.mapper;

import java.sql.ResultSet;

import app.model.ProvidersModel;

public class ProvidersMapper implements RowMapper<ProvidersModel>{

	@Override
	public ProvidersModel mapRow(ResultSet rs) {
		try {
			ProvidersModel provider = new ProvidersModel();
			provider.setId(rs.getInt("id"));
			provider.setName(rs.getString("name"));
			provider.setPhone(rs.getString("phone"));
			provider.setAddress(rs.getString("address"));
			provider.setStatus(rs.getString("status"));
			provider.setDescription(rs.getString("description"));
			provider.setCreateat(rs.getTimestamp("createat"));
			provider.setUpdateat(rs.getTimestamp("updateat"));
			provider.setIdEmployee(rs.getInt("idEmployee"));
			return provider;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
