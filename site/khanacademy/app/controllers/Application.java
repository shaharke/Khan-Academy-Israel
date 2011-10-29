package controllers;

import java.util.HashMap;
import java.util.Map;

import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import play.mvc.Controller;

public class Application extends Controller {
	
	private static Map<String, String> endpointMapping = new HashMap<String, String>();
	
	static {
		endpointMapping.put("google", "https://www.google.com/accounts/o8/id");
	}

	public static void home() {
		render();
	}

	public static void news() {
		render();
	}

	public static void forum() {
		render();
	}

	public static void contribute() {
		render();
	}

	public static void login() {
		render();
	}

	public static void authenticate(String serviceId) {
		String endpoint = endpointMapping.get(serviceId);
		if (endpoint != null) {
			if (OpenID.isAuthenticationResponse()) {
				UserInfo verifiedUser = OpenID.getVerifiedID();
				if (verifiedUser == null) {
					flash.error("Oops. Authentication has failed");
					login();
				}
				session.put("user", verifiedUser.id);
			}
			if (!OpenID.id(serviceId).verify()) {
				flash.error("Cannot verify your OpenID");
				login();
			}
			home();
		} 
	}

}