package it.unifi.dinfo.stdlab.projectJavalin.dto;

import it.unifi.dinfo.stdlab.projectJavalin.model.Designazione;
import it.unifi.dinfo.stdlab.projectJavalin.model.Squadra;

public class PartitaDto {
	private Long id;
	private Designazione designazione;
	private Squadra casa;
	private Squadra ospite;
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
	public Squadra getCasa() {
		return casa;
	}
	public void setCasa(Squadra casa) {
		this.casa = casa;
	}
	public Squadra getOspite() {
		return ospite;
	}
	public void setOspite(Squadra ospite) {
		this.ospite = ospite;
	}
	
	
}
