package org.khanacademy;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	
	private static final Logger logger = Logger.getLogger(ContactController.class.getName());
	
	private MessageSource messageSource;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new FeedbackValidator());
    }
	
	@RequestMapping(value = "/contact", method=RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("contact", "feedback", new Feedback());
	}
	
	@RequestMapping(value = "/contact", method=RequestMethod.POST)
	public ModelAndView send(@Valid Feedback feedback, BindingResult result) {
		if (result.hasErrors()) {
			return show();
		}
		boolean success = sendMail(feedback);
		ModelAndView mav = show();
		if (!success) {
			mav.addObject("status", new OperationStatus(success, messageSource.getMessage("send.feedback.failure", null, Locale.getDefault())));
		} else {
			mav.addObject("status", new OperationStatus(success, messageSource.getMessage("send.feedback.success", null, Locale.getDefault())));
		}
		return mav;
	}


	private boolean sendMail(Feedback feedback) {
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        try {
        	MimeMessage msg = new MimeMessage(session);
        	msg.setFrom(new InternetAddress("user.khan.ac.il@gmail.com", "Khan Academy Israel User"));
            /*
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress("hebrewkhan@gmail.com", "Hebrew Khan"));
                             */
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("shahar.khan.ac.il@gmail.com", "Khan Academy Israel"));
            msg.setSubject(feedback.getSubject(), "UTF-8");
            if (feedback.getEmail().isEmpty()) {
            	msg.setText(feedback.getMessage());
            } else {
            	String message = feedback.getMessage() + "\n\n" + "This message was sent by " + feedback.getEmail();
            	msg.setText(message);
            }
            Transport.send(msg);

        } catch (AddressException e) {
        	logger.log(Level.SEVERE, "Feedback message could not be sent: " + e.getMessage());
        	return false;
        } catch (MessagingException e) {
        	logger.log(Level.SEVERE, "Feedback message could not be sent: " + e.getMessage());
        	return false;
        } catch (UnsupportedEncodingException e) { return false;}
        return true;
	}
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	
}
