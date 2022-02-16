package it.unifi.dinfo.stdlab.projectJEE1.mapper;


import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE1.model.Designatore;
import it.unifi.dinfo.stdlab.projectJEE1.dao.DesignatoreDao;
import it.unifi.dinfo.stdlab.projectJEE1.dto.DesignatoreDto;


public class DesignatoreMapper {
	
	@Inject
	private DesignatoreDao dao;
	
	
	public DesignatoreDto convert(Designatore u) {
		if(u==null) 
			System.out.println("Designatore is NULL");
		
		DesignatoreDto dto =new DesignatoreDto();
		dto.setId(u.getId());
		dto.setDesignazione(u.getDesignazione());
		return dto;
	}

	

	



	public void transfer(DesignatoreDto dto, Designatore u) {
		if(dto==null)
			System.out.println("The Designatore Dto is NULL");
		if(u==null)
			System.out.println("The Designatore Entity is NULL");
		
		
	}

	



	

	public DesignatoreDao getDao() {
		return dao;
	}

	public void setDao(DesignatoreDao dao) {
		this.dao = dao;
	}
}
