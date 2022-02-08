package it.unifi.dinfo.stdlab.projectJEE.mapper;

import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE.dao.GiocatoreDao;
import it.unifi.dinfo.stdlab.projectJEE.dto.GiocatoreDto;
import it.unifi.dinfo.stdlab.projectJEE.model.Giocatore;

public class GiocatoreMapper {
	@Inject
	private GiocatoreDao dao;
	
	
	public GiocatoreDto convert(Giocatore u) {
		if(u==null) 
			System.out.println("Giocatore is NULL");
		
		GiocatoreDto dto =new GiocatoreDto();
		dto.setId(u.getId());
		dto.setSquadra(u.getSquadra());
		return dto;
	}


	public void transfer(GiocatoreDto dto, Giocatore u) {
		if(dto==null)
			System.out.println("The Giocatore Dto is NULL");
		if(u==null)
			System.out.println("The Giocatore Entity is NULL");
		
		u.setSquadra(dto.getSquadra());
		
	}

	



	

	public GiocatoreDao getDao() {
		return dao;
	}

	public void setDao(GiocatoreDao dao) {
		this.dao = dao;
	}
}
