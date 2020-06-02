package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomersDAO;
import app.dao.impl.EmployeesDAO;
import app.dao.impl.TransactionsDAO;
import app.mapper.CustomersMapper;
import app.model.CustomersModel;
import app.model.EmployeesModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class TransactionController {
	public TransactionController() {
		// TODO Auto-generated constructor stub
		get("/giao-dich", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		post("/get/giao-dich", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				TransactionsDAO transactionsDAO = new TransactionsDAO();
				return new Gson().toJson(transactionsDAO.findAll());
			}
		});
		post("/create/giao-dich", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomersModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomersModel.class);
				int id = new CustomersDAO().save(customersModel);
				customersModel.setId(id);
				return new Gson().toJson(customersModel);
			}
		});
		
//		post("/edit/giao-dich", new Route() {
//			
//			@Override
//			public Object handle(Request request, Response response) throws Exception {
//				CustomersModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomersModel.class);
//				new CustomersDAO().update(customersModel);
//				return new Gson().toJson(customersModel);
//			}
//		});
//		post("/delete/giao-dich", new Route() {
//			
//			@Override
//			public Object handle(Request request, Response response) throws Exception {
//				CustomersModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomersModel.class);
//				new CustomersDAO().delete(customersModel.getId());
//				return new Gson().toJson(customersModel.getId());
//			}
//		});
	}
}
