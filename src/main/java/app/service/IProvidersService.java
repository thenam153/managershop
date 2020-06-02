package app.service;

import java.util.List;

import app.model.ProvidersModel;

public interface IProvidersService {
	List<ProvidersModel> findAll();
	ProvidersModel findOne(int id);
}
