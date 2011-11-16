package controllers;

import java.util.List;

import com.google.appengine.api.users.User;

import models.Topic;
import play.mvc.*;

public class Catalog extends Controller {

    public static void show() {
    	List<Topic> topics = Topic.all().fetch();
        renderTemplate("/Catalog/catalog.html", topics);
    }
    
    public static void showJson() {
        renderJSON(models.User.all().fetch());
    }

}
