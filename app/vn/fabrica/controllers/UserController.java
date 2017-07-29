package vn.fabrica.controllers;

import play.*;
import play.api.libs.json.Json;
import play.data.Form;
import play.mvc.*;
import views.html.ui.user.*;
import vn.fabrica.dao.UserDAO;
import vn.fabrica.dto.User;
import vn.fabrica.utils.MessageUtil;
import vn.fabrica.utils.PagerUtil;
import views.html.helper.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import com.google.gson.Gson;

import controllers.routes;
import play.data.FormFactory;

public class UserController extends Controller {
	@Inject
	private FormFactory formFactory;
	
	@Inject
    private UserDAO userDAO;
	
	@Inject
	private PagerUtil pager;
	
	private Result GO_HOME = Results.redirect(
		vn.fabrica.controllers.routes.UserController.list(1)
	);
	
    public Result list(int page) {
    	List<User> users = null;
    	int totalCount = userDAO.count();
    	
    	if(totalCount>0){
    		pager.init(page, totalCount);
    		users = userDAO.all(pager);
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
        userDAO.insert(user);
        
        flash("success", MessageUtil.at("alert.success.created", "User", user.getFullname()));
        return GO_HOME;
    }
    
    public Result edit(int id) {
    	User user = userDAO.getUserById(id);
    	
    	if(user == null){
    		return notFound(MessageUtil.at("alert.fail.find.not_exist", "User", id));
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
        	userDAO.update(id, user);
        	
        	flash("success", MessageUtil.at("alert.success.updated", "User", user.getFullname()));
        	return GO_HOME;
        }
    }
    
    public Result delete(int id) {
    	User user = userDAO.getUserById(id);
    	if(user == null){
    		return notFound(MessageUtil.at("alert.fail.find.not_exist", "User", id));
    	}
    	
    	userDAO.delete(id);
    	flash("success", MessageUtil.at("alert.success.deleted", "User"));
    	
    	return GO_HOME;
    }
}
