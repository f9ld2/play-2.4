package controllers;

import play.*;
import play.api.libs.json.Json;
import play.data.Form;
import play.mvc.*;
import views.html.user.*;
import views.html.helper.form;
import model.User;
import java.util.List;
import javax.inject.Inject;

import com.google.gson.Gson;

import service.UserMapper;
import utils.Pager;
import play.data.FormFactory;

public class UserCtr extends Controller {
	@Inject
    private UserMapper userService;
	
	@Inject
	private FormFactory formFactory;
	
	private Result GO_HOME = Results.redirect(
         routes.UserCtr.list(1)
	);
	
    public Result list(int page) {
    	int pageSize = 10;
    	Pager pager = null;
    	List<User> users = null;
    	
    	int totalCount = userService.count();
    	
    	if(totalCount>0){
    		pager = new Pager(page, pageSize, totalCount);
    		
    		users = userService.all(
	    		Pager.getOffset(
					page, 
					pageSize, 
					totalCount
				), 
	    		pageSize
			);
    	}
    	
    	
        return ok(list.render(users, pager));
    }
    
    public Result create() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(createForm.render(userForm));
    }
    
    public Result save() {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if (userForm.hasErrors()) {
        	return badRequest(createForm.render(userForm));
        }

        User user = userForm.get();
        userService.insert(user);
        
        flash("success", "User " + user.getFullname() + " has been created");
        return GO_HOME;
    }
    
    public Result edit(int id) {
    	User user = userService.getUserById(id);
    	
    	if(user == null){
    		return notFound(String.format("User %s does not exist.", id));
    	}
    	
    	Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editForm.render(id, userForm));
    }
    
    public Result update(int id) {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        
        if (userForm.hasErrors()) {
        	return badRequest(editForm.render(id, userForm));
        } else {
        	User user = userForm.get();
        	userService.update(id, user);
        	
        	flash("success", "User " + user.getFullname() + " has been updated");
        	return GO_HOME;
        }
    }
    
    public Result delete(int id) {
    	User user = userService.getUserById(id);
    	if(user == null){
    		return notFound(String.format("User %s does not exist.", id));
    	}
    	
    	userService.delete(id);
    	flash("success", "User has been deleted");
    	
    	return GO_HOME;
    }
}
