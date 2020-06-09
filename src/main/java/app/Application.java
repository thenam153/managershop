package app;

import static spark.Spark.*;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.gson.Gson;

import app.controller.AuthenticateController;
import app.controller.CustomerController;
import app.controller.EmployeeController;
import app.controller.ProductController;
import app.controller.ProviderController;
import app.controller.TransactionController;
import app.controller.TransactionsDetailController;
import app.dao.impl.CustomerDAO;
import app.utils.ViewUtil;
import spark.Session;

import spark.Filter;
import spark.Request;
import spark.Response;


public class Application {
	
	public static void main(String[] args) {
		port(1503);
		staticFiles.location("/public");
		staticFiles.expireTime(600L);
		options("/*",
		        (request, response) -> {

		            String accessControlRequestHeaders = request
		                    .headers("Access-Control-Request-Headers");
		            if (accessControlRequestHeaders != null) {
		                response.header("Access-Control-Allow-Headers",
		                        accessControlRequestHeaders);
		            }

		            String accessControlRequestMethod = request
		                    .headers("Access-Control-Request-Method");
		            if (accessControlRequestMethod != null) {
		                response.header("Access-Control-Allow-Methods",
		                        accessControlRequestMethod);
		            }

		            return "OK";
		        });		
		before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
		new AuthenticateController();
		new CustomerController();
		new EmployeeController();
		new ProductController();
		new ProviderController();
		new TransactionController();
		new TransactionsDetailController();
	}
}
