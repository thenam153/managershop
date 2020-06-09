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
public class EmployeeController {
	public EmployeeController() {
		// TODO Auto-generated constructor stub
		post("/get/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				EmployeeDAO employeesDAO = new EmployeeDAO();
				return new Gson().toJson(employeesDAO.findAll());
			}
		});
		post("/create/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				EmployeeModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeeModel.class);
				int id = new EmployeeDAO().save(employeesModel);
				employeesModel.setId(id);
				return new Gson().toJson(employeesModel);
			}
		});
		post("/edit/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				EmployeeModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeeModel.class);
				new EmployeeDAO().update(employeesModel);
				return new Gson().toJson(employeesModel);
			}
		});
		post("/delete/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				EmployeeModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeeModel.class);
				new EmployeeDAO().delete(employeesModel.getId());
				return new Gson().toJson(employeesModel.getId());
			}
		});
	}
}
