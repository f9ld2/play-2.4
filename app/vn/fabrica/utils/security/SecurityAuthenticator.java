package vn.fabrica.utils.security;

import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;

public class SecurityAuthenticator extends Security.Authenticator{
	public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    public Result onUnauthorized(Context ctx) {
        return unauthorized(views.html.defaultpages.unauthorized.render());
    }
}
