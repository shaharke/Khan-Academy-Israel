package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.*;
 
@Entity(name = "user")
public class User extends Model {
 
	@Required
	@Email
    public String email;
	@Required
	@Password
    public String password;
    public String fullname;
    public boolean isAdmin;
    
    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
    
    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }
 
}