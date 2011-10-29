package controllers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.data.validation.Required;
import play.i18n.Messages;
import play.libs.Mail;
import play.mvc.Controller;

public class Contact extends Controller {

	public static void form() {
		render();
	}

	public static void send(@Required(message="contact.name.required") String name, String email, @Required(message="contact.subject.required") String subject, @Required(message="contact.message.required") String message) throws EmailException {
    	if (validation.hasErrors()) {
    		validation.keep();
    		params.flash();
    		form();
    	}
    	SimpleEmail mail = new SimpleEmail();
    	mail.setCharset("UTF-8");
    	mail.setFrom("user.khan.ac.il@gmail.com", "Khan Academy Israel User");
    	mail.addTo("hebrewkhan@gmail.com");
    	mail.addCc("shahar@gmail.com");
    	mail.setSubject(subject);
    	message = message + "\n\n" + "This message was sent by " + email;
    	mail.setMsg(message);
    	Mail.send(mail);
    	render();
    }
}
