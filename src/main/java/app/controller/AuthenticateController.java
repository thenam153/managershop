package app.controller;
//import static spark.Spark.get;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.dao.impl.CustomersDAO;
import app.dao.impl.EmployeesDAO;
import app.model.CustomersModel;
import app.model.EmployeesModel;
import app.utils.JsonTransformer;
import app.utils.Message;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import spark.routematch.RouteMatch;
public class AuthenticateController {
	private static CustomersDAO customersDAO = new CustomersDAO();
	private static EmployeesDAO employeesDAO = new EmployeesDAO();
	
	public AuthenticateController() {
		get("/dangnhap", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				EmployeesModel employee = request.session().attribute("authenticate");
				if(employee != null) {
					return new JsonTransformer().render(new Message(200, "Login Success"));
				}
//				Map<String, Object> model = new HashMap<>();
//				return ViewUtil.render(request, model, "/template/dist/index.html");
				return new Gson().toJson(customersDAO.findAll());
			}
		});
		
		post("/dangnhap", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				EmployeesModel employeesModel = new GsonBuilder().create().fromJson(request.body(), EmployeesModel.class);
				String reqUsername = employeesModel.getUsername();
				String reqPassword = employeesModel.getPassword();
				EmployeesModel employee = employeesDAO.findByUserName(reqUsername);
				if(employee == null) {
					return new JsonTransformer().render(new Message(401, "Authentication error"));
				}
				String password = employee.getPassword();
				if(reqPassword.equals(password)) {
					request.session().attribute("authenticate", employee);
					return new JsonTransformer().render(new Message(200, "Login Success"));
				}
//				System.out.println(request.params());
//				System.out.println(request.raw());
				return new JsonTransformer().render(new Message(400, "Bad request"));
			}
		});
		
		post("/dangxuat", new Route() {

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				request.session().removeAttribute("authenticate");
				response.redirect("/dangnhap");
				return null;
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
		
		get("/users", new Route() {

			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				Map<String, Object> model = new HashMap<>();
				return ViewUtil.render(request, model, "/template/dist/index.html");
			}
		});
	}
}
