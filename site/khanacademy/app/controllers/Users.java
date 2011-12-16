package controllers;

import controllers.CRUD;
import controllers.Secure;
import play.mvc.*;

@With(Secure.class)
public class Users extends CRUD {

}
