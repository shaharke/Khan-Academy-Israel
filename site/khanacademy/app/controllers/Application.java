package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import play.db.DB;
import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import play.mvc.Controller;
import play.mvc.With;

public class Application extends Controller {
	
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
	
}