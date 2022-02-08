package it.unifi.dinfo.stdlab.projectJEE.mapper;

import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE.dao.AnagraficaDao;
import it.unifi.dinfo.stdlab.projectJEE.dto.AnagraficaDto;
import it.unifi.dinfo.stdlab.projectJEE.model.Anagrafica;

public class AnagraficaMapper {
	@Inject
	private AnagraficaDao dao;
	
	
	public AnagraficaDto convert(Anagrafica u) {
		if(u==null) 
			System.out.println("Anagrafica is NULL");
		
		AnagraficaDto dto =new AnagraficaDto();
		dto.setId(u.getId());
		dto.setCf(u.getCf());
		dto.setArbitro(u.getArbitro());
		dto.setDesignatore(u.getDesignatore());
		
		
		return dto;
	}

	public void transfer(AnagraficaDto dto, Anagrafica u) {
		if(dto==null)
			System.out.println("The Anagrafica Dto is NULL");
		if(u==null)
			System.out.println("The Anagrafica Entity is NULL");
		
		u.setCf(dto.getCf());
		u.setArbitro(dto.getArbitro());
		u.setDesignatore(dto.getDesignatore());
		
	}

	



	public AnagraficaDao getDao() {
		return dao;
	}

	public void setDao(AnagraficaDao dao) {
		this.dao = dao;
	}
	
	
}
