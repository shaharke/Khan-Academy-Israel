package controllers;

import java.util.List;

import models.Topic;
import play.mvc.Controller;

public class Application extends Controller {
	
	public static void home() {
		List<Topic> topics = Topic.findAll();
		render(topics);
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