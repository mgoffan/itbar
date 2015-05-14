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

}
