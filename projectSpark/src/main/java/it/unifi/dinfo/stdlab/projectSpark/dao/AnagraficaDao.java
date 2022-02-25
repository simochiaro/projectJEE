package it.unifi.dinfo.stdlab.projectSpark.dao;

import java.util.List;

import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectSpark.model.Anagrafica;



public class AnagraficaDao {
	
	Database database=DB.getDefault();
	
	public Anagrafica findById(long id) {
		return null;
	}
	
	public List<Anagrafica> list(){
		return null;
	}
}
