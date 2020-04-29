package app.utils;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;

import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

public class ViewUtil {
	public static String render(Request request, Map<String, Object> model, String templatePath) {
		return strictVelocityEngine().render(new ModelAndView(model, templatePath));
//		return strictVelocityEngine().render(new ModelAndView(null, templatePath));
	}

	private static VelocityTemplateEngine strictVelocityEngine() {
		VelocityEngine configuredEngine = new VelocityEngine();
		configuredEngine.setProperty("runtime.references.strict", true);
		configuredEngine.setProperty("resource.loader", "class");
		configuredEngine.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		return new VelocityTemplateEngine(configuredEngine);
	}
}
