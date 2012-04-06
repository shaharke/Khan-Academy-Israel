package controllers;

import java.util.List;

import models.Lesson;
import models.SubTopic;
import models.Topic;
import play.mvc.Controller;

public class Catalog extends Controller {

    public static void show() {
		List<Topic> topics = Topic.all().fetch();
		sort(topics);
    	renderTemplate("/Catalog/catalog.html", topics);
    }

	private static void sort(List<Topic> topics) {
		Topic.sort(topics);
		for (Topic t : topics) {
			List<SubTopic> subtopics = t.subtopics;
			SubTopic.sort(subtopics);
			for (SubTopic st : subtopics) {
				Lesson.sort(st.lessons);
			}
		}
	}
    
}
