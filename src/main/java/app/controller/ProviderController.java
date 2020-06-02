package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomersDAO;
import app.dao.impl.EmployeesDAO;
import app.dao.impl.ProvidersDAO;
import app.mapper.CustomersMapper;
import app.model.CustomersModel;
import app.model.EmployeesModel;
import app.model.ProvidersModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class ProviderController {
	public ProviderController() {
		// TODO Auto-generated constructor stub
		get("/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		post("/get/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProvidersDAO providersDAO = new ProvidersDAO();
				return new Gson().toJson(providersDAO.findAll());
			}
		});
		post("/create/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProvidersModel providersModel = new GsonBuilder().create().fromJson(request.body(), ProvidersModel.class);
				int id = new ProvidersDAO().save(providersModel);
				providersModel.setId(id);
				return new Gson().toJson(providersModel);
			}
		});
		post("/edit/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProvidersModel providersModel = new GsonBuilder().create().fromJson(request.body(), ProvidersModel.class);
				new ProvidersDAO().update(providersModel);
				return new Gson().toJson(providersModel);
			}
		});
		post("/delete/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProvidersModel providersModel = new GsonBuilder().create().fromJson(request.body(), ProvidersModel.class);
				new ProvidersDAO().delete(providersModel.getId());
				return new Gson().toJson(providersModel.getId());
			}
		});
	}
}
