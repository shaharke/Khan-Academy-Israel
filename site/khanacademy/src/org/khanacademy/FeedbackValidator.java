package org.khanacademy;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FeedbackValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> feedbackClass) {
		return Feedback.class.equals(feedbackClass);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "empty.feedback.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "subject", "empty.feedback.subject");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "message", "empty.feedback.message");

	}

}
