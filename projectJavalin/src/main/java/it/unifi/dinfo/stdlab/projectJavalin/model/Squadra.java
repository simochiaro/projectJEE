package it.unifi.dinfo.stdlab.projectJavalin.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;


@Entity
@Table(name="Squadre")
public class Squadra {
	private String nome;
	
	@OneToOne(mappedBy="casa")
	private Partita casa;
	
	@OneToOne(mappedBy="ospite")
	private Partita ospite;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	
	
	private List<String> giocatori;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Partita getCasa() {
		return casa;
	}
	public void setCasa(Partita casa) {
		this.casa = casa;
	}
	
	
	public Partita getOspite() {
		return ospite;
	}
	public void setOspite(Partita ospite) {
		this.ospite = ospite;
	}
	
	
	public List<String> getGiocatori() {
		return giocatori;
	}
	public void setGiocatori(List<String> giocatori) {
		this.giocatori = giocatori;
	}
	
	
	
}
