package it.unifi.dinfo.stdlab.projectSpark.dto;

import it.unifi.dinfo.stdlab.projectSpark.model.Arbitro;

public class RefertoDto {
	private Arbitro arbitro;
	private Long id;
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
