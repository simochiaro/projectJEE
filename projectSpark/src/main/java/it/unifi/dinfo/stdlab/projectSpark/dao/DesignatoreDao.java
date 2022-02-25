package it.unifi.dinfo.stdlab.projectSpark.dao;

import java.util.List;



import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectSpark.model.Arbitro;
import it.unifi.dinfo.stdlab.projectSpark.model.Designatore;



public class DesignatoreDao {
	Database database=DB.getDefault();
	
	
	public Designatore findById(long id) {
		return null;
	}
	
	public List<Designatore> list(){
		return null;
	}

	public void rifiutaDesignazione(Arbitro a) {
		
		
	}
}