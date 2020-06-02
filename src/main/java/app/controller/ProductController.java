package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomersDAO;
import app.dao.impl.EmployeesDAO;
import app.dao.impl.ProductsDAO;
import app.mapper.CustomersMapper;
import app.model.CustomersModel;
import app.model.EmployeesModel;
import app.model.ProductsModel;
import app.model.ProvidersModel;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class ProductController {
	public ProductController() {
		// TODO Auto-generated constructor stub
		get("/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		post("/get/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductsDAO productsDAO = new ProductsDAO();
				return new Gson().toJson(productsDAO.findAll());
			}
		});
		post("/create/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductsModel productsModel = new GsonBuilder().create().fromJson(request.body(), ProductsModel.class);
				int id = new ProductsDAO().save(productsModel);
				productsModel.setId(id);
				return new Gson().toJson(productsModel);
			}
		});
		post("/edit/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductsModel productsModel = new GsonBuilder().create().fromJson(request.body(), ProductsModel.class);
				new ProductsDAO().update(productsModel);
				return new Gson().toJson(productsModel);
			}
		});
		post("/delete/san-pham", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				ProductsModel productsModel = new GsonBuilder().create().fromJson(request.body(), ProductsModel.class);
				new ProductsDAO().delete(productsModel.getId());
				return new Gson().toJson(productsModel.getId());
			}
		});
	}
}
