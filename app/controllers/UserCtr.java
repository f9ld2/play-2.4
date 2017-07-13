package controllers;

import play.*;
import play.mvc.*;
import service.UserMapper;
import views.html.*;
import model.User;

import javax.inject.Inject;

public class UserCtr extends Controller {
	@Inject
    private UserMapper userMapper;

    public Result listUsers() {
    	//userMapper.insert(new User(null, "Test 3"));
    	//userMapper.update(new User(1, "Test x"));
    	//userMapper.delete(4);
    	
        return ok(users.render(userMapper.all(), userMapper.getUserById(1)));
    }
}
