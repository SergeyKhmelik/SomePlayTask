package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;


public class SwaggerController extends Controller {

    public Result mainSwaggerPage(){
        return ok(swagger.render());
    }
}
