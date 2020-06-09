package app.controller;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static spark.Spark.*;

import app.dao.impl.CustomerDAO;
import app.dao.impl.EmployeeDAO;
import app.dao.impl.ProductDAO;
import app.dao.impl.TransactionDAO;
import app.dao.impl.TransactionsDetailDAO;
import app.mapper.CustomerMapper;
import app.model.CustomerModel;
import app.model.EmployeeModel;
import app.model.ProductModel;
import app.model.TransactionsDetailModel;
import app.model.TransactionModel;
import app.utils.JsonTransformer;
import app.utils.MapperModel;
import app.utils.Message;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class TransactionsDetailController {
	public TransactionsDetailController() {
		// TODO Auto-generated constructor stub
		post("/get/giao-dich/chi-tiet", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				TransactionsDetailDAO transactionsDetailsDAO = new TransactionsDetailDAO();
				TransactionDAO transactionsDAO = new TransactionDAO();
				ProductDAO productsDAO = new ProductDAO();
				CustomerDAO customersDAO = new CustomerDAO();
				return new Gson().toJson(new MapperModel(transactionsDetailsDAO.findAll(), transactionsDAO.findAll(), productsDAO.findAll(), customersDAO.findAll()) );
			}
		});
		post("/create/giao-dich/chi-tiet", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				TransactionsDetailModel transactionsDetailsModel = new GsonBuilder().create().fromJson(request.body(), TransactionsDetailModel.class);
				int id = new TransactionsDetailDAO().save(transactionsDetailsModel);
				ProductModel model = new ProductDAO().findOne(transactionsDetailsModel.getIdProduct());
				int quantily = model.getQuantily() - transactionsDetailsModel.getQuantily();
				if(quantily < 0) {
					return new JsonTransformer().render(new Message(200, "Quantily must be greater"));
				}
				model.setQuantily(quantily);
				new ProductDAO().update(model);
				transactionsDetailsModel.setId(id);
				return new Gson().toJson(transactionsDetailsModel);
			}
		});
	}
}
