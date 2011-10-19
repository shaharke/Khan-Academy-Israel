package models;

public class Feedback {
	
	private String name;
	
	private String email;
	
	private String message;
	
	private String subject;
	
	public Feedback() {
		// Default ctor.
	}
	
	public Feedback(String name, String email, String message, String subject) {
		this(name, message, subject);
		this.email = email;
	}
	
	public Feedback(String name, String message, String subject) {
		this.name = name;
		this.message = message;
		this.setSubject(subject);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
