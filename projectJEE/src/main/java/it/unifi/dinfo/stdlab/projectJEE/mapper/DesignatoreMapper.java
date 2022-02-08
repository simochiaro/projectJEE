package it.unifi.dinfo.stdlab.projectJEE.mapper;

import java.util.List;

import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE.dao.DesignatoreDao;
import it.unifi.dinfo.stdlab.projectJEE.dto.DesignatoreDto;
import it.unifi.dinfo.stdlab.projectJEE.model.Designatore;
import it.unifi.dinfo.stdlab.projectJEE.model.Designazione;


public class DesignatoreMapper {
	@Inject
	private DesignatoreDao dao;
	
	
	public DesignatoreDto convert(Designatore u) {
		if(u==null) 
			System.out.println("Designatore is NULL");
		
		DesignatoreDto dto =new DesignatoreDto();
		dto.setId(u.getId());
		serializeDesignazioni(dto, u);
		return dto;
	}

	private void serializeDesignazioni(DesignatoreDto dto, Designatore u) {
		dto.getDesignazione().clear();
		if(u.getDesignazione().size()>0) {
			for (Designazione des : u.getDesignazione()) {
				dto.getDesignazione().add(des);
			}
		}
		
	}

	public void transfer(DesignatoreDto dto, Designatore u) {
		if(dto==null)
			System.out.println("The Designatore Dto is NULL");
		if(u==null)
			System.out.println("The Designatore Entity is NULL");
		
		deSerializeDesignazione(u,dto.getDesignazione());
	}

	



	private void deSerializeDesignazione(Designatore u, List<Designazione> designazione) {
		u.getDesignazione().clear();
		if(designazione!=null && designazione.size()>0) {
			for(Designazione des :designazione) {
				u.getDesignazione().add(des);
			}
		}
		
	}

	public DesignatoreDao getDao() {
		return dao;
	}

	public void setDao(DesignatoreDao dao) {
		this.dao = dao;
	}
}
