package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomersDAO;
import app.dao.impl.EmployeesDAO;
import app.mapper.CustomersMapper;
import app.model.CustomersModel;
import app.model.EmployeesModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class CustomerController {
	public CustomerController() {
		// TODO Auto-generated constructor stub
		get("/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		post("/get/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomersDAO customersDAO = new CustomersDAO();
				return new Gson().toJson(customersDAO.findAll());
			}
		});
		post("/create/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomersModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomersModel.class);
				int id = new CustomersDAO().save(customersModel);
				customersModel.setId(id);
				return new Gson().toJson(customersModel);
			}
		});
		post("/edit/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomersModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomersModel.class);
				new CustomersDAO().update(customersModel);
				return new Gson().toJson(customersModel);
			}
		});
		post("/delete/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				CustomersModel customersModel = new GsonBuilder().create().fromJson(request.body(), CustomersModel.class);
				new CustomersDAO().delete(customersModel.getId());
				return new Gson().toJson(customersModel.getId());
			}
		});
	}
}
