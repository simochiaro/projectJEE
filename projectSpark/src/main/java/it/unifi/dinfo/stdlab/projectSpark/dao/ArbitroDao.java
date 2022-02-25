package it.unifi.dinfo.stdlab.projectSpark.dao;

import java.util.List;



import io.ebean.DB;
import io.ebean.Database;

import it.unifi.dinfo.stdlab.projectSpark.model.Arbitro;
import it.unifi.dinfo.stdlab.projectSpark.model.Partita;




public class ArbitroDao {
	Database database=DB.getDefault();
	
	
	public ArbitroDao findById(long id) {
		return null;
	}
	
	public List<Arbitro> list(){
		return null;
	}

	public void accettaDesignazione(Arbitro a) {
		this.database.update(Arbitro.class).set("nuova_designazione", false).where().in("id", a.getId()).update();
		
	}

	public void connectPartita(Arbitro a,Partita partita) {
		this.database.update(Arbitro.class).set("partita_id", partita.getId()).where().in("id", a.getId()).update();
		
	}

	public void detachPartita(Arbitro a) {
		this.database.update(Arbitro.class).set("partita_id", null).where().in("id", a.getId()).update();
		
	}

	public void notifyDesignazione(Arbitro a) {
		this.database.update(Arbitro.class).set("nuova_designazione", true).where().in("id", a.getId()).update();
		
	}

	

	


	

	

	

	
	
}