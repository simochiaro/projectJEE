package it.unifi.dinfo.stdlab.projectJEE.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Giocatore")
public class Giocatore {
	private Squadra squadra;
	private Referto amm;
	private Long id;
	private String nome;
	private String cognome;
	private Date nascita;
	
	@ManyToOne(targetEntity=Squadra.class)
	public Squadra getSquadra() {
		return squadra;
	}
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	
	@ManyToOne(targetEntity=Referto.class)
	public Referto getAmm() {
		return amm;
	}
	public void setAmm(Referto amm) {
		this.amm = amm;
	}
	
	
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	
	
}
