package it.unifi.dinfo.stdlab.projectJEE.dto;

import it.unifi.dinfo.stdlab.projectJEE.model.Squadra;

public class GiocatoreDto {
	private Squadra squadra;
	private Long id;
	public Squadra getSquadra() {
		return squadra;
	}
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
