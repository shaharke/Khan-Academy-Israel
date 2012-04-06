package models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity(name = "subtopic")
public class SubTopic extends Model {
	
	@Required
	public String name;
	
	@MaxSize(1000)
	public String description;
	
	public String englishName;
	
	@Required
	@Column(name = "sort")
	public int order;
	
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = true)
	public Topic topic;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="topic")
	public List<Lesson> lessons;
	
	public static List<SubTopic> sort(List<SubTopic> topics) {
		Collections.sort(topics, new Comparator<SubTopic>() {

			@Override
			public int compare(SubTopic o1, SubTopic o2) {
				return o1.order - o2.order;
			}
		});
		return topics;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
