package it.unifi.dinfo.stdlab.projectJEE1.dto;

import java.util.List;

import it.unifi.dinfo.stdlab.projectJEE1.model.Designazione;
import it.unifi.dinfo.stdlab.projectJEE1.model.Referto;

public class ArbitroDto {
	private List<Referto> referti;
	private Long id;
	private Designazione designazione;
	private Boolean nuovaDesignazione;
	
	
	public Boolean getNuovaDesignazione() {
		return nuovaDesignazione;
	}
	public void setNuovaDesignazione(Boolean nuovaDesignazione) {
		this.nuovaDesignazione = nuovaDesignazione;
	}
	public List<Referto> getReferti() {
		return referti;
	}
	public void setReferti(List<Referto> referti) {
		this.referti = referti;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Designazione getDesignazione() {
		return designazione;
	}
	public void setDesignazione(Designazione designazione) {
		this.designazione = designazione;
	}
	
	
}
