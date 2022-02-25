package it.unifi.dinfo.stdlab.projectSpark.mapper;


import it.unifi.dinfo.stdlab.projectSpark.dao.SquadraDao;
import it.unifi.dinfo.stdlab.projectSpark.dto.SquadraDto;
import it.unifi.dinfo.stdlab.projectSpark.model.Squadra;

public class SquadraMapper {
	
	private SquadraDao dao=new SquadraDao();
	
	
	public SquadraDto convert(Squadra u) {
		if(u==null) 
			System.out.println("Squadra is NULL");
		
		SquadraDto dto =new SquadraDto();
		dto.setId(u.getId());
		dto.setNome(u.getNome());
		
		return dto;
	}


	public void transfer(SquadraDto dto, Squadra u) {
		if(dto==null)
			System.out.println("The Squadra Dto is NULL");
		if(u==null)
			System.out.println("The Squadra Entity is NULL");
		
		u.setNome(dto.getNome());
	}

	



	

	public SquadraDao getDao() {
		return dao;
	}

	public void setDao(SquadraDao dao) {
		this.dao = dao;
	}
}
