package it.unifi.dinfo.stdlab.projectJavalin.dao;

import java.util.List;

import io.ebean.DB;
import io.ebean.Database;
import it.unifi.dinfo.stdlab.projectJavalin.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;
import it.unifi.dinfo.stdlab.projectJavalin.model.Referto;



public class RefertoDao {
	Database database=DB.getDefault();
	
	
	public Referto findById(long id) {
		return null;
	}
	
	public List<Referto> list(){
		return null;
	}

	public void creaReferto(Arbitro a, String esito, String amm, String esp) {
		Referto ref=new Referto();
		ref.setAmm(amm);
		ref.setArbitro(a);
		ref.setEsito(esito);
		ref.setEsp(esp);
		ref.setPartita(a.getPartita());
		this.database.insert(ref);
		
	}

	public Referto ricercaReferto(Arbitro a,Partita p) {
		Referto ref=this.database.find(Referto.class)  
			    .where().in("arbitro_id",a.getId()).in("partita_id", p.getId()).findOne();
		return ref;
	}

	public void generaSupplemento(Referto ref, String supplemento) {
		this.database.update(Referto.class).set("supplemento", supplemento).where().in("id", ref.getId()).update();
		
	}

	
}