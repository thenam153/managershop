package app.service;

import java.util.List;

import app.model.TransactionsModel;

public interface ITransactionsService {
	List<TransactionsModel> findAll();
	TransactionsModel findOne(int id);
}
