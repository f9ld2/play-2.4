package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import service.UserMapper;
import javax.inject.Inject;

public class Application extends Controller {
	@Inject
    private UserMapper userService;

    public Result listUsers() {
        return ok(users.render(userService.all()));
    }
}
