package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomerDAO;
import app.dao.impl.EmployeeDAO;
import app.dao.impl.ProviderDAO;
import app.mapper.CustomerMapper;
import app.model.CustomerModel;
import app.model.EmployeeModel;
import app.model.ProviderModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class ProviderController {
	public ProviderController() {
		// TODO Auto-generated constructor stub
		post("/get/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProviderDAO providersDAO = new ProviderDAO();
				return new Gson().toJson(providersDAO.findAll());
			}
		});
		post("/create/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProviderModel providersModel = new GsonBuilder().create().fromJson(request.body(), ProviderModel.class);
				int id = new ProviderDAO().save(providersModel);
				providersModel.setId(id);
				return new Gson().toJson(providersModel);
			}
		});
		post("/edit/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProviderModel providersModel = new GsonBuilder().create().fromJson(request.body(), ProviderModel.class);
				new ProviderDAO().update(providersModel);
				return new Gson().toJson(providersModel);
			}
		});
		post("/delete/cung-cap", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProviderModel providersModel = new GsonBuilder().create().fromJson(request.body(), ProviderModel.class);
				new ProviderDAO().delete(providersModel.getId());
				return new Gson().toJson(providersModel.getId());
			}
		});
	}
}
