package it.unifi.dinfo.stdlab.projectJEE.dto;

import it.unifi.dinfo.stdlab.projectJEE.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE.model.Designatore;

public class AnagraficaDto {
	private Long id;
	private String cf;
	private Designatore designatore;
	private Arbitro arbitro;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public Designatore getDesignatore() {
		return designatore;
	}
	public void setDesignatore(Designatore designatore) {
		this.designatore = designatore;
	}
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	
}
