package app.controller;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
public class UserController {
	
	public UserController() {
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
