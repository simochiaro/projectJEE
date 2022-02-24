package it.unifi.dinfo.stdlab.projectJavalin.mapper;


import it.unifi.dinfo.stdlab.projectJavalin.dao.PartitaDao;
import it.unifi.dinfo.stdlab.projectJavalin.dto.PartitaDto;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;

public class PartitaMapper {
	
	private PartitaDao dao=new PartitaDao();
	
	
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
