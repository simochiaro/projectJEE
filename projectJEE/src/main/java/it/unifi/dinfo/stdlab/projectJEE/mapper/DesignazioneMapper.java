package it.unifi.dinfo.stdlab.projectJEE.mapper;



import javax.inject.Inject;
import it.unifi.dinfo.stdlab.projectJEE.dao.DesignazioneDao;
import it.unifi.dinfo.stdlab.projectJEE.dto.DesignazioneDto;
import it.unifi.dinfo.stdlab.projectJEE.model.Designazione;


public class DesignazioneMapper {
	@Inject
	private DesignazioneDao dao;
	
	
	public DesignazioneDto convert(Designazione u) {
		if(u==null) 
			System.out.println("Designazione is NULL");
		
		DesignazioneDto dto =new DesignazioneDto();
		dto.setId(u.getId());
		dto.setArbitro(u.getArbitro());
		dto.setPartita(u.getPartita());
		return dto;
	}


	public void transfer(DesignazioneDto dto, Designazione u) {
		if(dto==null)
			System.out.println("The Designazione Dto is NULL");
		if(u==null)
			System.out.println("The Designazione Entity is NULL");
		
		u.setArbitro(dto.getArbitro());
		u.setPartita(dto.getPartita());
	}

	



	

	public DesignazioneDao getDao() {
		return dao;
	}

	public void setDao(DesignazioneDao dao) {
		this.dao = dao;
	}
}
