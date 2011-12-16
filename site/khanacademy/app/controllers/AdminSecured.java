package controllers;

import play.mvc.Before;
import models.User;

public class AdminSecured extends Secure {
	
	@Before(unless={"login", "authenticate", "logout"})
    static void checkAccess() throws Throwable {
		Secure.checkAccess();
		check();
    }
	
	
	static void check() {
		if (!User.find("byEmail", Security.connected()).<User>first().isAdmin) {
			forbidden();
		}
    }

}
