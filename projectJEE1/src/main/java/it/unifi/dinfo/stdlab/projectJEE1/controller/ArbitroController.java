package it.unifi.dinfo.stdlab.projectJEE1.controller;

import javax.ws.rs.core.Response;

import it.unifi.dinfo.stdlab.projectJEE1.dto.UserDto;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.ArbitroMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.PartitaMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.RefertoMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.UserMapper;
import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Referto;
import it.unifi.dinfo.stdlab.projectJEE1.model.User;

public class ArbitroController {

	public Response creaReferto(String username, String esito, String amm, String esp) {
		
			UserMapper uM=new UserMapper();
			User u=uM.getDao().findByUsername(username);
			UserDto uD=uM.convert(u);
			Arbitro a=uD.getArbitro();
			ArbitroMapper aM=new ArbitroMapper();
			RefertoMapper rM=new RefertoMapper();
			PartitaMapper pM=new PartitaMapper();
			if(a.getPartita()==null)
				return Response
						.ok()
						.entity("Nessun referto da creare")
						.build();
			else {
				aM.getDao().connectDesignazione(a);
				pM.getDao().esitoPartita(a.getPartita(),esito);
				rM.getDao().creaReferto(a,esito,amm,esp);
				aM.getDao().disconnectPartita(a);
				return Response
						.ok()
						.entity("Referto Creato:\n "+ "Partita:"+a.getDesignazione().getPartita().getCasa().getNome() +" vs "+a.getDesignazione().getPartita().getOspite().getNome()+
								"\n Data:"+ a.getDesignazione().getData()+
								"\n ESITO:"+esito+"\n Ammonizioni:"+amm+"\n ESPULSIONI:"+esp)
						.build();
			}
		}

	public Response ricercaReferto(String username, String casa, String ospite) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Arbitro a=uD.getArbitro();
		RefertoMapper rM=new RefertoMapper();
		Referto ref=rM.getDao().searchByTeam(a,casa,ospite);
		if(ref==null)
			return Response
					.ok()
					.entity("Nessun referto trovato")
					.build();
		else {
			
			return Response
					.ok()
					.entity("Referto :\n "+ "Partita:"+ref.getPartita().getCasa().getNome() +" vs "+ref.getPartita().getOspite().getNome()+
							
							"\n ESITO:"+ref.getEsito()+"\n Ammonizioni:"+ref.getAmm()+"\n ESPULSIONI:"+ref.getEsp())
					.build();
		}
	}

	public Response supplementoReferto(String username, String casa, String ospite,String supplemento) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Arbitro a=uD.getArbitro();
		RefertoMapper rM=new RefertoMapper();
		Referto ref=rM.getDao().searchByTeam(a,casa,ospite);
		if(ref==null)
			return Response
					.ok()
					.entity("Nessun referto trovato")
					.build();
		else {
			rM.getDao().generaSupplemento(ref,supplemento);
			return Response
					.ok()
					.entity("Supplemento Referto generato :\n "+ "Partita:"+ref.getPartita().getCasa().getNome() +" vs "+ref.getPartita().getOspite().getNome()+
							
							"\n ESITO:"+ref.getEsito()+"\n Ammonizioni:"+ref.getAmm()+"\n ESPULSIONI:"+ref.getEsp()+"\n Supplemento:"+supplemento)
					.build();
		}
	}

}


