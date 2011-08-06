package org.khanacademy;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FeedbackValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Feedback.class.equals(clazz) || OperationStatus.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "empty.feedback.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "subject", "empty.feedback.subject");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "message", "empty.feedback.message");

	}

}
