package app.controller;
//import static spark.Spark.get;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.dao.impl.CustomerDAO;
import app.dao.impl.EmployeeDAO;
import app.model.CustomerModel;
import app.model.EmployeeModel;
import app.utils.JsonTransformer;
import app.utils.Message;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import spark.routematch.RouteMatch;
public class AuthenticateController {
	private static CustomerDAO customersDAO = new CustomerDAO();
	private static EmployeeDAO employeesDAO = new EmployeeDAO();
	
	public AuthenticateController() {
		get("/dangnhap", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				EmployeeModel employee = request.session().attribute("authenticate");
				if(employee != null) {
					return new JsonTransformer().render(new Message(200, "Login Success"));
				}
				return new Gson().toJson(customersDAO.findAll());
			}
		});
		
		post("/dangnhap", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				EmployeeModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeeModel.class);
				String reqUsername = employeesModel.getUsername();
				String reqPassword = employeesModel.getPassword();
				EmployeeModel employee = employeesDAO.findByUserName(reqUsername);
				if(employee == null) {
					return new JsonTransformer().render(new Message(401, "Authentication error"));
				}
				String password = employee.getPassword();
				if(reqPassword.equals(password)) {
					request.session().attribute("authenticate", employee);
					return new JsonTransformer().render(new Message(200, employee.getId().toString()));
				}
				return new JsonTransformer().render(new Message(400, "Bad request"));
			}
		});
		
		post("/dangxuat", new Route() {

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				request.session().removeAttribute("authenticate");
				return new JsonTransformer().render(new Message(200, "Success"));
			}
			
		});
		get("/dangxuat", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				request.session().removeAttribute("authenticate");
				response.redirect("/dangnhap");
				return null;
			}
		});
	}
}
