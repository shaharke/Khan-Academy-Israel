package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity(name = "topic")
public class Topic extends Model {
	
	public String name;
	
	public String description;
	
	public String englishName;
	
	public int order;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="topic")
	public List<Lesson> lessons;
	
	public static List<Topic> sort(List<Topic> topics) {
		Collections.sort(topics, new Comparator<Topic>() {

			@Override
			public int compare(Topic o1, Topic o2) {
				return o1.order - o2.order;
			}
		});
		return topics;
	}
    
}
