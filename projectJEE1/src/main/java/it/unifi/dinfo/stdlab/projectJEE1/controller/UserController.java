package it.unifi.dinfo.stdlab.projectJEE1.controller;




import javax.ws.rs.core.Response;

import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.User;
import it.unifi.dinfo.stdlab.projectJEE1.dto.UserDto;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.ArbitroMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.DesignazioneMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.UserMapper;



public class UserController {

	
	public Response nuovaDesignazione(String username) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Arbitro a=uD.getArbitro();
		ArbitroMapper aM=new ArbitroMapper();
		
		if(!a.getNuova_designazione())
			return Response
					.ok()
					.entity("Nessuna Nuova Designazione:")
					.build();
		else
			aM.getDao().connectDesignazione(a);
			return Response
					.ok()
					.entity("Nuova Designazione:\n "+ "Partita:"+a.getDesignazione().getPartita().getCasa().getNome() +" vs "+a.getDesignazione().getPartita().getOspite().getNome()+
							"\n Data:"+ a.getDesignazione().getData())
					.build();
	}

	public Response accettaDesignazione(String username) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Arbitro a=uD.getArbitro();
		ArbitroMapper aM=new ArbitroMapper();
		DesignazioneMapper dM=new DesignazioneMapper();
		if(!a.getNuova_designazione())
			return Response
					.ok()
					.entity("Nessuna Nuova Designazione:")
					.build();
		else {
			aM.getDao().connectDesignazione(a);
			aM.getDao().accettaDesignazione(a);
			dM.getDao().accettaDesignazione(a);
			
			return Response
					.ok()
					.entity("Designazione:\n "+ "Partita:"+a.getDesignazione().getPartita().getCasa().getNome() +" vs "+a.getDesignazione().getPartita().getOspite().getNome()+
							"\n Data:"+ a.getDesignazione().getData()+
							"\n ACCETTATA")
					.build();
		}
	}
	
	
	public Response rifiutaDesignazione(String username) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Arbitro a=uD.getArbitro();
		ArbitroMapper aM=new ArbitroMapper();
		DesignazioneMapper dM=new DesignazioneMapper();
		if(!a.getNuova_designazione())
			return Response
					.ok()
					.entity("Nessuna Nuova Designazione:")
					.build();
		else {
			aM.getDao().connectDesignazione(a);
			aM.getDao().rifiutaDesignazione(a);
			dM.getDao().rifiutaDesignazione(a);
			
			return Response
					.ok()
					.entity("Designazione:\n "+ "Partita:"+a.getDesignazione().getPartita().getCasa().getNome() +" vs "+a.getDesignazione().getPartita().getOspite().getNome()+
							"\n Data:"+ a.getDesignazione().getData()+
							"\n RIFIUTATA")
					.build();
		}
	}

}
