package controllers;

import java.util.List;

import models.Lesson;
import models.SubTopic;
import models.Topic;
import play.mvc.Controller;

public class Application extends Controller {
	
	public static void home() {
		render();
	}
	
	public static void catalog() {
		List<Topic> topics = Topic.all().fetch();
		sort(topics);
		render(topics);
	}
	
	public static void contribute() {
		render();
	}

	public static void login() {
		render();
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