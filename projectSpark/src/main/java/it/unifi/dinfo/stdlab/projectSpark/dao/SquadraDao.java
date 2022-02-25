package it.unifi.dinfo.stdlab.projectSpark.dao;

import java.util.List;

import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectSpark.model.Squadra;




public class SquadraDao {
	Database database=DB.getDefault();
	
	
	public Squadra findById(long id) {
		return null;
	}
	
	public List<Squadra> list(){
		return null;
	}

	public Long findByName(String casat) {
		Squadra s=this.database.find(Squadra.class).where().in("nome", casat).findOne();
		Long id=s.getId();
		return id;
	}
}
