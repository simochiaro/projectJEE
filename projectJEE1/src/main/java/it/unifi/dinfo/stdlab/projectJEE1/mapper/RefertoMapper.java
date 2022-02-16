package it.unifi.dinfo.stdlab.projectJEE1.mapper;

import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE1.model.Referto;
import it.unifi.dinfo.stdlab.projectJEE1.dao.RefertoDao;
import it.unifi.dinfo.stdlab.projectJEE1.dto.RefertoDto;

public class RefertoMapper {
	@Inject
	private RefertoDao dao;
	
	
	public RefertoDto convert(Referto u) {
		if(u==null) 
			System.out.println("Referto is NULL");
		
		RefertoDto dto =new RefertoDto();
		dto.setId(u.getId());
		dto.setArbitro(u.getArbitro());
		return dto;
	}


	public void transfer(RefertoDto dto, Referto u) {
		if(dto==null)
			System.out.println("The Referto Dto is NULL");
		if(u==null)
			System.out.println("The Referto Entity is NULL");
		
		u.setArbitro(dto.getArbitro());
		
	}

	



	

	public RefertoDao getDao() {
		return dao;
	}

	public void setDao(RefertoDao dao) {
		this.dao = dao;
	}
}
