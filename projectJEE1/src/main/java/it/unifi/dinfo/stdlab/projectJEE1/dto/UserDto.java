package it.unifi.dinfo.stdlab.projectJEE1.dto;

import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designatore;

public class UserDto {
	private Long id;
	private String username;
	private Arbitro arbitro;
	private Designatore designatore;
	
	
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	public Designatore getDesignatore() {
		return designatore;
	}
	public void setDesignatore(Designatore designatore) {
		this.designatore = designatore;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
