package models;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
