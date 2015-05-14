package controllers;

import java.util.List;

import models.MenuItem;
import models.Pic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class MenuItemController extends Controller {
	
	private static Form<MenuItem> menuItemForm = Form.form(MenuItem.class);
	private static Form<Pic> picForm = Form.form(Pic.class);
	
    public static Result api() {
    	
    	ObjectNode result = Json.newObject();
    	
    	result.put("err", 0);
    	result.put("msg", "API is running");
    	
    	/*
    	 * ObjectMapper mapper = new ObjectMapper();
    	 * List<MenuItem> items = MenuItem.find().all();
    	 * ArrayNode array = mapper.valueToTree(items);
    	 * result.putArray("result").addAll(array);
    	 */
    	
    	return ok(result);
    }
    
    /**
     * /POST /api/item
     * @return
     */
    public static Result createItem() {
    	
    	Form<MenuItem> filledForm = menuItemForm.bindFromRequest();
    	
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
    
    /**
     * /POST /api/item/:id/pic
     * @param id
     * @return
     */
    public static Result addPicToItem(Long id) {
    	
    	Form<Pic> filledForm = picForm.bindFromRequest();
    	
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
    
    /**
     * / GET /api/item/:id
     * @param id
     * @return
     */
    public static Result getItem(Long id) {
    	
    	
    	ObjectNode result = Json.newObject();
    	
    	result.put("err", ErrorCodes.RESPONSE_OK);
    	result.put("msg", "Operacion OK");
    	result.put("result", Json.toJson(MenuItem.find().byId(id)));
    		
    	return ok(result);
    }
}
