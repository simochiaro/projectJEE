package it.unifi.dinfo.stdlab.projectJEE.mapper;

import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE.dao.PartitaDao;
import it.unifi.dinfo.stdlab.projectJEE.dto.PartitaDto;
import it.unifi.dinfo.stdlab.projectJEE.model.Partita;

public class PartitaMapper {
	@Inject
	private PartitaDao dao;
	
	
	public PartitaDto convert(Partita u) {
		if(u==null) 
			System.out.println("Partita is NULL");
		
		PartitaDto dto =new PartitaDto();
		dto.setId(u.getId());
		dto.setDesignazione(u.getDesignazione());
		dto.setOspite(u.getOspite());
		dto.setCasa(u.getCasa());
		return dto;
	}


	public void transfer(PartitaDto dto, Partita u) {
		if(dto==null)
			System.out.println("The Partita Dto is NULL");
		if(u==null)
			System.out.println("The Partita Entity is NULL");
		
		u.setDesignazione(dto.getDesignazione());
		u.setOspite(dto.getOspite());
		u.setCasa(dto.getCasa());
	}

	



	

	public PartitaDao getDao() {
		return dao;
	}

	public void setDao(PartitaDao dao) {
		this.dao = dao;
	}
}
