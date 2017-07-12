package controllers;

import play.*;
import play.mvc.*;
import service.UserMapper;
import views.html.*;
import model.User;

import javax.inject.Inject;

public class Application extends Controller {
	@Inject
    private UserMapper userService;

    public Result listUsers() {
    	//userService.insert(new User(null, "Test 3"));
    	//userService.update(new User(1, "Test x"));
    	//userService.delete(4);
    	
        return ok(users.render(userService.all()));
    }
}
