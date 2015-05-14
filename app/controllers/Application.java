package controllers;

import java.util.List;

import play.*;
import play.libs.Json;
import play.mvc.*;
import scala.collection.immutable.Seq;
import views.html.*;
import models.MenuItem;
import play.api.libs.json.*;
import play.data.Form;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	
    	List<MenuItem> items = MenuItem.find().all();
    	
    	
    	ArrayNode array = mapper.valueToTree(items);
    	
    	result.putArray("result").addAll(array);
    	
    	return ok(result);
    }
    
    public static Result createItem() {
    	
    	Form<MenuItem> menuItemForm = Form.form(MenuItem.class);
    	Form<MenuItem> filledForm = menuItemForm.bindFromRequest(request());
    	
    	ObjectNode result = Json.newObject();
    	
    	if(filledForm.hasErrors()) {
    		
    		result.put("err", 3);
    		result.put("msg", filledForm.errorsAsJson());
    		
    		return badRequest(result);
    	} else {
    		MenuItem.create(filledForm.get());
    		
    		result.put("err", 0);
    		result.put("msg", "Operacion OK");
    		result.put("result", Json.toJson(filledForm.get()));
    		
    		return ok(result);  
    	}
    	
    }

}
