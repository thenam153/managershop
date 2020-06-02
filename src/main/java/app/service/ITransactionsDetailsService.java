package app.service;

import java.util.List;

import app.model.TransactionsDetailsModel;

public interface ITransactionsDetailsService {
	List<TransactionsDetailsModel> findAll();
	TransactionsDetailsModel findOne(int id);
}
