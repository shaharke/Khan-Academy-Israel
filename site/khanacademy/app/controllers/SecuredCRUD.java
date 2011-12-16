package controllers;

import play.mvc.*;

@With(AdminSecured.class)
public class SecuredCRUD extends CRUD {

}
