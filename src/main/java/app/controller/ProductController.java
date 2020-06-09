package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomerDAO;
import app.dao.impl.EmployeeDAO;
import app.dao.impl.ProductDAO;
import app.mapper.CustomerMapper;
import app.model.CustomerModel;
import app.model.EmployeeModel;
import app.model.ProductModel;
import app.model.ProviderModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class ProductController {
	public ProductController() {
		// TODO Auto-generated constructor stub
		post("/get/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductDAO productsDAO = new ProductDAO();
				return new Gson().toJson(productsDAO.findAll());
			}
		});
		post("/create/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductModel productsModel = new GsonBuilder().create().fromJson(request.body(), ProductModel.class);
				int id = new ProductDAO().save(productsModel);
				productsModel.setId(id);
				return new Gson().toJson(productsModel);
			}
		});
		post("/edit/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductModel productsModel = new GsonBuilder().create().fromJson(request.body(), ProductModel.class);
				new ProductDAO().update(productsModel);
				return new Gson().toJson(productsModel);
			}
		});
		post("/delete/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductModel productsModel = new GsonBuilder().create().fromJson(request.body(), ProductModel.class);
				new ProductDAO().delete(productsModel.getId());
				return new Gson().toJson(productsModel.getId());
			}
		});
	}
}
