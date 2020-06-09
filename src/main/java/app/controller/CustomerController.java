package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomerDAO;
import app.dao.impl.EmployeeDAO;
import app.mapper.CustomerMapper;
import app.model.CustomerModel;
import app.model.EmployeeModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class CustomerController {
	public CustomerController() {
		// TODO Auto-generated constructor stub
		post("/get/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomerDAO customersDAO = new CustomerDAO();
				return new Gson().toJson(customersDAO.findAll());
			}
		});
		post("/create/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				CustomerModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomerModel.class);
				int id = new CustomerDAO().save(customersModel);
				customersModel.setId(id);
				return new Gson().toJson(customersModel);
			}
		});
		post("/edit/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomerModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomerModel.class);
				new CustomerDAO().update(customersModel);
				return new Gson().toJson(customersModel);
			}
		});
		post("/delete/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomerModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomerModel.class);
				new CustomerDAO().delete(customersModel.getId());
				return new Gson().toJson(customersModel.getId());
			}
		});
	}
}
