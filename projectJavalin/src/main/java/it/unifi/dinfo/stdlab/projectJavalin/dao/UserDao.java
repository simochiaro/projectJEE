package it.unifi.dinfo.stdlab.projectJavalin.dao;

import java.util.List;

import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectJavalin.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJavalin.model.User;



public class UserDao {
	Database database=DB.getDefault();
	
	

	
	
	public User findById(Long l) {
		return null;
	}
	
	public List<User> list(){
		return null;
	}

	public User findByUsernameWithRoles(String principalusername) {
		return null;
	}

	
	public User findByUsername(String username) {
		return this.database.find(User.class)  
			    .where().in("username",username).findOne();
	}

	public Arbitro getByUsername(String username) {
		User u =   this.database.find(User.class)  
			    .where().in("username",username).findOne();
		return u.getArbitro();
	}
}
