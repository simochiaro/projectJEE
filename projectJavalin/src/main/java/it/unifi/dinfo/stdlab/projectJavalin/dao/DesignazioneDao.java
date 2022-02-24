package it.unifi.dinfo.stdlab.projectJavalin.dao;


import java.sql.Date;
import java.util.List;




import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectJavalin.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designatore;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designazione;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;





public class DesignazioneDao {
	Database database=DB.getDefault();
	
	public Designazione findById(long id) {
		return null;
	}
	
	public List<Designazione> list(){
		return null;
	}
	
	public void accettaDesignazione(Designazione des) {
		this.database.update(Designazione.class).set("accettata", true).where().in("id", des.getId()).update();
	      
	      
	}

	public Designazione findDesignazione(Arbitro a) {
		Designazione d =   this.database.find(Designazione.class)  
			    .where().in("arbitro.id",a.getId()).in("accettata", false).in("rifiutata", false).findOne();
		return d;
	}

	public void rifiutaDesignazione(Designazione des) {
		this.database.update(Designazione.class).set("rifiutata", true).where().in("id", des.getId()).update();
	     
	}

	public Designazione creaDesignazione(Designatore des, Arbitro a, Partita partita,Date data) {
		Designazione d =new Designazione();
		d.setAccettata(false);
		d.setArbitro(a);
		d.setData(data);
		d.setDesignatore(des);
		d.setPartita(partita);
		d.setRifiutata(false);
		this.database.insert(d);
		return d;
	}

	public boolean controllaRifiuti(Designatore des) {
		Designazione designazione=this.database.find(Designazione.class).where().in("designatore_id", des.getId()).in("rifiutata", true).findOne();
		if (designazione==null)
			return false;
		return true;
	}

	public void ridesignaRifiuto(Designatore des, Arbitro ar) {
		Designazione d=this.database.find(Designazione.class).where().in("designatore_id", des.getId()).in("rifiutata", true).findOne();
		Arbitro arbitro=d.getArbitro();
		this.database.update(Arbitro.class).set("rifiuti", arbitro.getRifiuti()+1).where().in("id", arbitro.getId()).update();
		this.database.update(Designazione.class).set("arbitro_id", ar.getId()).set("rifiutata", false).where().in("designatore_id", des.getId()).in("rifiutata", true).update();
		
	}

}