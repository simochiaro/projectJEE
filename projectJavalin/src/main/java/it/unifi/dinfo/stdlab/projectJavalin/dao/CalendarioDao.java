package it.unifi.dinfo.stdlab.projectJavalin.dao;

import java.util.List;

import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectJavalin.model.Calendario;



public class CalendarioDao {
	Database database=DB.getDefault();
	
	
	public Calendario findById(long id) {
		return null;
	}
	
	public List<Calendario> list(){
		return null;
	}
}
