package models;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity(name = "lesson")
public class Lesson extends Model {

	@Required
	public String hebrewName;
	
	public String originalName;
	
	@Required
	@play.data.validation.URL
	
	public String url;
	
	@MaxSize(1000)
	public String description;

	@Required
	public int serialNumber;

	@Required
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	public Topic topic;

	public static List<Lesson> sort(List<Lesson> lessons) {
		Collections.sort(lessons, new Comparator<Lesson>() {

			@Override
			public int compare(Lesson o1, Lesson o2) {
				return o1.serialNumber - o2.serialNumber;
			}

		});
		return lessons;
	}

}
