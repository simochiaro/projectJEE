package it.unifi.dinfo.stdlab.projectJavalin.mapper;


import it.unifi.dinfo.stdlab.projectJavalin.dao.CalendarioDao;

import it.unifi.dinfo.stdlab.projectJavalin.dto.CalendarioDto;
import it.unifi.dinfo.stdlab.projectJavalin.model.Calendario;

public class CalendarioMapper {
	
	private CalendarioDao dao=new CalendarioDao();
	
	
	public CalendarioDto convert(Calendario u) {
		if(u==null) 
			System.out.println("Calendario is NULL");
		
		CalendarioDto dto =new CalendarioDto();
		dto.setId(u.getId());
		
		return dto;
	}


	public void transfer(CalendarioDto dto, Calendario u) {
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
