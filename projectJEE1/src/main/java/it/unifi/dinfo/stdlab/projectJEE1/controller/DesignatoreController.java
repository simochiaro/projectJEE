package it.unifi.dinfo.stdlab.projectJEE1.controller;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import it.unifi.dinfo.stdlab.projectJEE1.dto.UserDto;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.ArbitroMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.DesignatoreMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.PartitaMapper;
import it.unifi.dinfo.stdlab.projectJEE1.mapper.UserMapper;
import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designatore;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designazione;
import it.unifi.dinfo.stdlab.projectJEE1.model.Partita;
import it.unifi.dinfo.stdlab.projectJEE1.model.User;

public class DesignatoreController {

	public Response creaDesignazione(String username, String idA,String data, String casa,String ospite) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Designatore des=uD.getDesignatore();
		DesignatoreMapper dM=new DesignatoreMapper();
		List<Partita> par=dM.getDao().findPartite(des);
		PartitaMapper pM=new PartitaMapper();
		if(par==null)
			return Response
					.ok()
					.entity("Nessuna partita da designare")
					.build();
		for(Partita partit : par)
			System.out.println(partit.getCasa().getNome());
		Partita p=pM.getDao().findPartita(par, casa, ospite);
		if(p==null)
			return Response
					.ok()
					.entity("Partita non trovata")
					.build();
		
		else {
			ArbitroMapper aM=new ArbitroMapper();
			Long id=Long.parseLong(idA);
			Arbitro a=aM.getDao().findById(id);
			Date dat=Date.valueOf(data);
			dM.getDao().creaDesignazione(des,a,p,dat);
			pM.getDao().updatePartita(p);
			aM.getDao().updateNuova(a);
			return Response
					.ok()
					.entity("Partita Designata: \n PARTITA:"+p.getCasa().getNome()+" vs "+p.getOspite().getNome()+
							"\n Data:"+dat+"\n Arbitro:"+a.getAnagrafica().getNome()+" "+a.getAnagrafica().getCognome())
					.build();
		}
	}

	public Response controllaRifiuti(String username) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Designatore des=uD.getDesignatore();
		DesignatoreMapper dM=new DesignatoreMapper();
		Designazione rifiuti=dM.getDao().controllaRifiuti(des);
		if(rifiuti==null)
			return Response
					.ok()
					.entity("Nessuna Designazione Rifiutata")
					.build();
		else {
			return Response
					.ok()
					.entity("Ci sono partite da Ridesignare")
					.build();
		}
	}

	public Response ridesignaPartita(String username, String idA) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Designatore des=uD.getDesignatore();
		DesignatoreMapper dM=new DesignatoreMapper();
		Designazione rifiuto=dM.getDao().controllaRifiuti(des);
		if(rifiuto==null)
			return Response
					.ok()
					.entity("Nessuna Designazione Rifiutata")
					.build();
		else {
			Long id=Long.parseLong(idA);
			dM.getDao().ridesignaPartita(rifiuto,id);
			ArbitroMapper aM=new ArbitroMapper();
			Arbitro a=aM.getDao().findById(id);
			aM.getDao().updateNuova(a);
			return Response
					.ok()
					.entity("Partita ridesignata!")
					.build();
		}
	}

	public Response contatoreRifiuto(String username) {
		UserMapper uM=new UserMapper();
		User u=uM.getDao().findByUsername(username);
		UserDto uD=uM.convert(u);
		Designatore des=uD.getDesignatore();
		DesignatoreMapper dM=new DesignatoreMapper();
		Designazione rifiuto=dM.getDao().controllaRifiuti(des);
		if(rifiuto==null)
			return Response
					.ok()
					.entity("Nessuna Designazione Rifiutata")
					.build();
		else {
			dM.getDao().aggiornaContatoreRifiuto(rifiuto);
			return Response
					.ok()
					.entity("Contatore Aggiornato!")
					.build();
		}
	}

}
