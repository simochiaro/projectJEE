package it.unifi.dinfo.stdlab.projectJavalin.controller;



import it.unifi.dinfo.stdlab.projectJavalin.mapper.ArbitroMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.DesignazioneMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.PartitaMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.RefertoMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.SquadraMapper;
import it.unifi.dinfo.stdlab.projectJavalin.mapper.UserMapper;
import it.unifi.dinfo.stdlab.projectJavalin.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designazione;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;
import it.unifi.dinfo.stdlab.projectJavalin.model.Referto;

public class ArbitroController {


	public Partita controllaDesignazione(String username) {
		UserMapper uM=new UserMapper();
		Arbitro a=uM.getDao().getByUsername(username);
		if (!a.getNuova_designazione())
			return null;
		DesignazioneMapper dM=new DesignazioneMapper();
		Partita partita=dM.getDao().findDesignazione(a).getPartita();
		return partita;
	}

	public Designazione accettaDesignazione(String username) {
		UserMapper uM=new UserMapper();
		Arbitro a=uM.getDao().getByUsername(username);
		if (!a.getNuova_designazione())
			return null;
		DesignazioneMapper dM=new DesignazioneMapper();
		Designazione des=dM.getDao().findDesignazione(a);
		ArbitroMapper aM=new ArbitroMapper();
		aM.getDao().accettaDesignazione(a);
		aM.getDao().connectPartita(a,des.getPartita());
		dM.getDao().accettaDesignazione(des);
		return des;
	}

	public Designazione rifiutaDesignazione(String username) {
		UserMapper uM=new UserMapper();
		Arbitro a=uM.getDao().getByUsername(username);
		if (!a.getNuova_designazione())
			return null;
		DesignazioneMapper dM=new DesignazioneMapper();
		Designazione des=dM.getDao().findDesignazione(a);
		ArbitroMapper aM=new ArbitroMapper();
		aM.getDao().accettaDesignazione(a);
		dM.getDao().rifiutaDesignazione(des);
		return des;
	}

	public boolean creaReferto(String username, String esito, String amm, String esp) {
		UserMapper uM=new UserMapper();
		Arbitro a=uM.getDao().getByUsername(username);
		if (a.getPartita()==null)
			return false;
		RefertoMapper rM=new RefertoMapper();
		rM.getDao().creaReferto(a,esito,amm,esp);
		PartitaMapper pM=new PartitaMapper();
		pM.getDao().notificaEsito(a.getPartita(),esito);
		ArbitroMapper aM=new ArbitroMapper();
		aM.getDao().detachPartita(a);
		return true;
	}

	public Referto ricercaReferto(String username, String casat, String ospitet) {
		UserMapper uM=new UserMapper();
		Arbitro a=uM.getDao().getByUsername(username);
		RefertoMapper rM=new RefertoMapper();
		SquadraMapper sM=new SquadraMapper();
		Long casa=sM.getDao().findByName(casat);
		Long ospite=sM.getDao().findByName(ospitet);
		PartitaMapper pM=new PartitaMapper();
		Partita p=pM.getDao().findByTeam(casa,ospite);
		Referto ref =rM.getDao().ricercaReferto(a,p);
		return ref;
	}

	public void generaSupplemento(Referto ref,String supplemento) {
		RefertoMapper rM=new RefertoMapper();
		rM.getDao().generaSupplemento(ref,supplemento);
		
	}

}
