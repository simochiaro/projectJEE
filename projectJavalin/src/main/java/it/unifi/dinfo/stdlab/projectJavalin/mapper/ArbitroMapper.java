package it.unifi.dinfo.stdlab.projectJavalin.mapper;

import java.util.List;

import it.unifi.dinfo.stdlab.projectJavalin.dao.ArbitroDao;
import it.unifi.dinfo.stdlab.projectJavalin.dto.ArbitroDto;
import it.unifi.dinfo.stdlab.projectJavalin.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJavalin.model.Referto;




public class ArbitroMapper {
	
	
	private ArbitroDao dao=new ArbitroDao();
	
	
	public ArbitroDto convert(Arbitro u) {
		if(u==null) 
			System.out.println("Arbitro is NULL");
		
		ArbitroDto dto =new ArbitroDto();
		dto.setId(u.getId());
		dto.setDesignazione(u.getDesignazione());
		dto.setNuovaDesignazione(u.getNuova_designazione());
		serializeReferti(dto, u);
		return dto;
	}

	private void serializeReferti(ArbitroDto dto, Arbitro u) {
		dto.getReferti().clear();
		if(u.getReferti().size()>0) {
			for (Referto ref : u.getReferti()) {
				dto.getReferti().add(ref);
			}
		}
		
	}

	public void transfer(ArbitroDto dto, Arbitro u) {
		if(dto==null)
			System.out.println("The Arbitro Dto is NULL");
		if(u==null)
			System.out.println("The Arbitro Entity is NULL");
		
		u.setDesignazione(dto.getDesignazione());
		u.setNuova_designazione(dto.getNuovaDesignazione());
		deSerializeReferti(u,dto.getReferti());
	}

	



	private void deSerializeReferti(Arbitro u, List<Referto> referti) {
		u.getReferti().clear();
		if(referti!=null && referti.size()>0) {
			for(Referto ref :referti) {
				u.getReferti().add(ref);
			}
		}
		
	}

	public ArbitroDao getDao() {
		return dao;
	}

	public void setDao(ArbitroDao dao) {
		this.dao = dao;
	}
}
