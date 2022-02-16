package it.unifi.dinfo.stdlab.projectJEE1.dto;

import java.util.List;


import it.unifi.dinfo.stdlab.projectJEE1.model.Designazione;
import it.unifi.dinfo.stdlab.projectJEE1.model.Partita;

public class DesignatoreDto {
	private Long id;
	private Designazione designazione;
	private List<Partita> partita;
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
	public List<Partita> getPartita() {
		return partita;
	}
	public void setPartita(List<Partita> partita) {
		this.partita = partita;
	}
	
	
}
