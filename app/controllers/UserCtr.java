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
	
    public Result list(int id) {
    	List<User> users = userService.all();
        return ok(list.render(users));
    }
    
    public Result create(){
    	Form<User> userForm = formFactory.form(User.class);
    	
    	if (request().method().equals("POST")) {
    		userForm = userForm.bindFromRequest();
    		
    		if(!userForm.hasErrors()){
    			User user = userForm.get();
    			userService.insert(user);
    			
    			flash("success", "User " + user.getFullname() + " has been created");
    			return redirect(routes.UserCtr.list(1));
    		}
    	}
    	
    	return ok(create.render(userForm));
    }
    
    public Result update(int id){
    	User user = userService.getUserById(id);
    	
    	if(user == null){
    		return notFound(String.format("User %s does not exist.", id));
    	}
    	
    	Form<User> userForm = formFactory
    							.form(User.class)
    							.fill(user);
    	
    	if (request().method().equals("POST")) {
    		userForm = userForm.bindFromRequest();
    		
    		if(!userForm.hasErrors()){
    			userService.update(id, userForm.get());
    			flash("success", "User " + userForm.get().getFullname() + " has been updated");
    			
    			return redirect(routes.UserCtr.list(1));
    		}
    	}
    	 
    	return ok(update.render(id, userForm));
    }
    
    public Result delete(int id) {
    	User user = userService.getUserById(id);
    	if(user == null){
    		return notFound(String.format("User %s does not exist.", id));
    	}
    	
    	userService.delete(id);
    	return redirect(routes.UserCtr.list(1));
    }
}
