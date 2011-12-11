package models;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity(name = "lesson")
public class Lesson extends Model {
	
	public String hebrewName;
	public String originalName;
	public URL url;
	public String description;
	public int serialNumber;
	
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	public Topic topic;
    
}
