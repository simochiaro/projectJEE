package it.unifi.dinfo.stdlab.projectJEE1.mapper;



import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Calendario;
import it.unifi.dinfo.stdlab.projectJEE1.dao.CalendarioDao;
import it.unifi.dinfo.stdlab.projectJEE1.dto.ArbitroDto;
import it.unifi.dinfo.stdlab.projectJEE1.dto.CalendarioDto;

public class CalendarioMapper {
	@Inject
	private CalendarioDao dao;
	
	
	public CalendarioDto convert(Calendario u) {
		if(u==null) 
			System.out.println("Calendario is NULL");
		
		CalendarioDto dto =new CalendarioDto();
		dto.setId(u.getId());
		
		return dto;
	}


	public void transfer(ArbitroDto dto, Arbitro u) {
		if(dto==null)
			System.out.println("The Arbitro Dto is NULL");
		if(u==null)
			System.out.println("The Arbitro Entity is NULL");
		
		
	}

	


	public CalendarioDao getDao() {
		return dao;
	}

	public void setDao(CalendarioDao dao) {
		this.dao = dao;
	}
}
