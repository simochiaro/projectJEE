package it.unifi.dinfo.stdlab.projectJavalin.dto;

import java.util.List;

import it.unifi.dinfo.stdlab.projectJavalin.model.Designazione;

public class DesignatoreDto {
	private Long id;
	private List<Designazione> designazione;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Designazione> getDesignazione() {
		return designazione;
	}
	public void setDesignazione(List<Designazione> designazione) {
		this.designazione = designazione;
	}
	
	
}
