package controllers;

import java.util.List;


import play.libs.Json;
import play.mvc.*;

import views.html.*;
import models.MenuItem;
import models.Pic;

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
    		
    		result.put("err", ErrorCodes.RESPONSE_ERROR);
    		result.put("msg", filledForm.errorsAsJson());
    		
    		return badRequest(result);
    	} else {
    		MenuItem.create(filledForm.get());
    		
    		result.put("err", ErrorCodes.RESPONSE_OK);
    		result.put("msg", "Operacion OK");
    		result.put("result", Json.toJson(filledForm.get()));
    		
    		return ok(result);  
    	}
    	
    }
    
    public static Result addPicToItem(Long id) {
    	
    	Form<Pic> filledForm = Form.form(Pic.class).bindFromRequest();
    	
    	ObjectNode result = Json.newObject();
    	
    	if(filledForm.hasErrors()) {
    		
    		result.put("err", ErrorCodes.RESPONSE_ERROR);
    		result.put("msg", filledForm.errorsAsJson());
    		
    		return badRequest(result);
    	} else {
    		
    		Pic.create(filledForm.get(), id);
    		
    		result.put("err", ErrorCodes.RESPONSE_OK);
    		result.put("msg", "Operacion OK");
    		result.put("result", Json.toJson(MenuItem.find().byId(id)));
    		
    		return ok(result);  
    	}
    }
    
    public static Result getItem(Long id) {
    	
    	
    	ObjectNode result = Json.newObject();
    	
    	result.put("err", ErrorCodes.RESPONSE_OK);
    	result.put("msg", "Operacion OK");
    	result.put("result", Json.toJson(MenuItem.find().byId(id)));
    		
    	return ok(result);
    }

}
