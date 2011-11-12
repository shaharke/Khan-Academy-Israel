package models;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Lesson extends Model {
	
	public String hebrewName;
	public String originalName;
	public URL url;
	public String description;
	public int serialNumber;
	
	@OneToOne
	@JoinColumn(name = "subject_id")
	public Subject subject;
	
	@OneToOne
	@JoinColumn(name = "topic_id")
	public Topic topic;
    
}
