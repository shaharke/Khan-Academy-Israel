package controllers;

import play.mvc.*;

public class Admin extends Controller {
	
	@Before
	static void checkAuthenticated() {
	    if(!session.contains("user")) {
	        Application.login();
	    }
	}

    public static void index() {
        render();
    }

}
