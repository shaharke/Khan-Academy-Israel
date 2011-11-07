package controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import models.Lesson;
import models.Subject;
import models.Topic;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

	public static void form() {
		List<Subject> subjects = Subject.all().fetch();
		List<Topic> topics = Topic.all().fetch();
		render(subjects, topics);
	}

	public static void addLesson(
			@Required(message = "addLesson.nameInHebrew.required") String hebrewName,
			@Required(message = "addLesson.originalName.required") String originalName,
			String description,
			@Required(message = "addLesson.url.required") String url,
			Long subject, Long topic,
			@Required(message = "addLesson.serial.required") int serialNumber)
			throws MalformedURLException {
		
		if (validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}
		Lesson lesson = new Lesson();
		lesson.hebrewName = hebrewName;
		lesson.originalName = originalName;
		lesson.serialNumber = serialNumber;
		lesson.description = description;
		try {
			lesson.url = new URL(url);
		} catch (MalformedURLException e) {
			validation.addError("url", "addLesson.url.malformed",
					e.getMessage());
			validation.keep();
			params.flash();
			form();
		}
		lesson.subject = Subject.findById(subject);
		lesson.topic = Topic.findById(subject);
		lesson.save();
		form();
	}

}
