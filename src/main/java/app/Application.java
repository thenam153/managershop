package app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.gson.Gson;

import app.controller.UserController;
import app.dao.impl.CustomersDAO;
import app.model.CategoryModel;
import app.service.impl.CategoryService;
import app.utils.ViewUtil;

public class Application {
	@Inject
    private static CategoryService categoryService = new CategoryService();
	private static List<CategoryModel> categoryModel = new ArrayList<CategoryModel>();
	private static CustomersDAO customersDAO = new CustomersDAO();
	
	public static void main(String[] args) {
		port(1503);
		staticFiles.location("/public");
		staticFiles.expireTime(600L);
		new UserController();
		get("/book", (req, res) -> {
//        	return new Gson().toJson(new StandardResponse("SUCCESS", new Gson().toJsonTree(new Book("Moby Dick", "Herman Melville", "9789583001215"))));
//			return new Gson().toJson(new Book());
			Map<String, Object> model = new HashMap<>();
	        model.put("users", "data");
	        model.put("book", "dádđ");
			return ViewUtil.render(req, model, "/template/index.html");
        });
		get("/bokok", (req, res) -> {
			return new Gson().toJson(customersDAO.findAll());
		});
		get("/book123", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			return ViewUtil.render(req, model, "/template/dist/index.html");
        });
		
	}
}