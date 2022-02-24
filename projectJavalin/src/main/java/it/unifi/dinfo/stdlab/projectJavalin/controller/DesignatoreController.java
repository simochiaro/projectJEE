package it.unifi.dinfo.stdlab.projectJavalin.controller;

import java.sql.Date;

import it.unifi.dinfo.stdlab.projectJavalin.mapper.ArbitroMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.DesignazioneMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.PartitaMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.UserMapper;
import it.unifi.dinfo.stdlab.projectJavalin.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designatore;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designazione;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;
import it.unifi.dinfo.stdlab.projectJavalin.model.User;

public class DesignatoreController {

	public Designazione generaDesignazione(String username, String arbitro, Date data) {
		UserMapper uM=new UserMapper();
		User d=uM.getDao().findByUsername(username);
		User a=uM.getDao().findByUsername(arbitro);
		Arbitro ar=a.getArbitro();
		Designatore des=d.getDesignatore();
		PartitaMapper pM=new PartitaMapper();
		Partita partita=pM.getDao().searchDesignabile(des);
		
		
		DesignazioneMapper deM=new DesignazioneMapper();
		Designazione designazione=deM.getDao().creaDesignazione(des,ar,partita,data);
		ArbitroMapper aM=new ArbitroMapper();
		aM.getDao().notifyDesignazione(ar);
		pM.getDao().notifyDesignazione(partita);
		return designazione;
	}

	public Boolean controllaRifiuti(String username) {
		UserMapper uM=new UserMapper();
		User d=uM.getDao().findByUsername(username);
		Designatore des=d.getDesignatore();
		DesignazioneMapper dM=new DesignazioneMapper();
		return dM.getDao().controllaRifiuti(des);
	}

	public void designaRifiuto(String username, String arbitro) {
		UserMapper uM=new UserMapper();
		User d=uM.getDao().findByUsername(username);
		User a=uM.getDao().findByUsername(arbitro);
		Arbitro ar=a.getArbitro();
		Designatore des=d.getDesignatore();
		DesignazioneMapper dM=new DesignazioneMapper();
		dM.getDao().ridesignaRifiuto(des,ar);
		ArbitroMapper aM=new ArbitroMapper();
		aM.getDao().notifyDesignazione(ar);
		
	}


	

}
