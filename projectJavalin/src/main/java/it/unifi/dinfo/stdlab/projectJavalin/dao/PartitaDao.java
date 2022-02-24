package it.unifi.dinfo.stdlab.projectJavalin.dao;

import java.util.List;

import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designatore;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;




public class PartitaDao {
	Database database=DB.getDefault();
	
	
	public Partita findById(long id) {
		return null;
	}
	
	public List<Partita> list(){
		return null;
	}

	public void notificaEsito(Partita partita, String esito) {
		this.database.update(Partita.class).set("esito", esito).where().in("id", partita.getId()).update();
		
	}

	public Partita findByTeam(Long casa, Long ospite) {
		return this.database.find(Partita.class).where().in("casa_id", casa).in("ospite_id", ospite).findOne();
	}

	public Partita searchDesignabile(Designatore des) {
		return this.database.find(Partita.class).where().in("categoria", des.getCategoria()).findOne();
	}

	public void notifyDesignazione(Partita partita) {
		 this.database.update(Partita.class).set("designata",true).where().in("id", partita.getId()).update();
		
	}
}