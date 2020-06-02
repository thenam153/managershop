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
public class Controller {
	public Controller() {
		// TODO Auto-generated constructor stub
		get("/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		
		get("/giao-dich", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		
		get("/khach-hang", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		
		get("/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		
		get("/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		
		post("/get/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				EmployeesDAO employeesDAO = new EmployeesDAO();
				return new Gson().toJson(employeesDAO.findAll());
			}
		});
		post("/create/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				EmployeesModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeesModel.class);
				int id = new EmployeesDAO().save(employeesModel);
				employeesModel.setId(id);
				return new Gson().toJson(employeesModel);
			}
		});
		post("/edit/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				EmployeesModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeesModel.class);
				new EmployeesDAO().update(employeesModel);
				return new Gson().toJson(employeesModel);
			}
		});
		post("/delete/nhan-vien", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				EmployeesModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeesModel.class);
				new EmployeesDAO().delete(employeesModel.getId());
				return new Gson().toJson(employeesModel.getId());
			}
		});

		
		

		post("/get/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/create/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/edit/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/delete/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});

		post("/get/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/create/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/edit/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/delete/thanh-toan", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});

		post("/get/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/create/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/edit/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
		post("/delete/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				
				return null;
			}
		});
	}
}
