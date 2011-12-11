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
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="topic")
	public List<Lesson> lessons;
    
}
