package controllers;

import play.*;
import play.api.libs.json.Json;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import views.html.helper.form;
import model.User;
import java.util.List;
import javax.inject.Inject;

import com.google.gson.Gson;

import service.UserMapper;
import play.data.FormFactory;

public class UserCtr extends Controller {
	@Inject
    private UserMapper userService;
	
	@Inject
	private FormFactory formFactory;

    public Result list() {
    	List<User> users = userService.all();
        return ok(list.render(users));
    }
    
    public Result delete(Integer id) {
    	User user = userService.getUserById(id);
    	if(user == null){
    		return notFound();
    	}
    	
    	userService.delete(id);
    	return redirect(routes.UserCtr.list());
    }
    
    public Result input(Integer id){
    	Form<User> userForm = formFactory.form(User.class);
    	if(id != null){
    		User user = userService.getUserById(id);
    		userForm = userForm.fill(user);
    	}
    	
    	return ok(input.render(userForm));
    }
    
    public Result save(){
    	 Form<User> userForm = formFactory.form(User.class).bindFromRequest();
    	 
    	 if(userForm.hasErrors()){
    		 return ok(input.render(userForm));
    	 }
    	 
    	 return redirect(routes.UserCtr.list());
    }
}
