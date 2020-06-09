package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomerDAO;
import app.dao.impl.EmployeeDAO;
import app.dao.impl.TransactionDAO;
import app.mapper.CustomerMapper;
import app.model.CustomerModel;
import app.model.EmployeeModel;
import app.model.TransactionModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class TransactionController {
	public TransactionController() {
		// TODO Auto-generated constructor stub
		post("/get/giao-dich", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				TransactionDAO transactionsDAO = new TransactionDAO();
				return new Gson().toJson(transactionsDAO.findAll());
			}
		});
		post("/create/giao-dich", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				TransactionModel transactionsModel = new GsonBuilder().create().fromJson(request.body(), TransactionModel.class);
				int id = new TransactionDAO().save(transactionsModel);
				transactionsModel.setId(id);
				return new Gson().toJson(transactionsModel);
			}
		});
	}
}
