package controllers;

import play.*;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public static Result api() {
    	
    	ObjectNode result = Json.newObject();
    	
    	result.put("err", 0);
    	result.put("msg", "API is running");
    	
    	return ok(result);
    }

}
