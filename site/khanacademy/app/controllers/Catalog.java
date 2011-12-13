package controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Lesson;
import models.Topic;
import play.cache.Cache;
import play.mvc.Controller;

public class Catalog extends Controller {

    public static void show() {
    	List<Topic> topics = Cache.get("topics", List.class);
    	if (topics == null) {
    		topics = Topic.all().fetch();
    		Cache.set("topics", topics, "10mn");
    		sort(topics);
    	}
    	renderTemplate("/Catalog/catalog.html", topics);
    }

	private static void sort(List<Topic> topics) {
		Topic.sort(topics);
		for (Topic t : topics) {
			Lesson.sort(t.lessons);
		}
	}
    
}
