package it.unifi.dinfo.stdlab.projectJEE.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Anagrafica")
public class Anagrafica {
	private String nome;
	private Long id;
	private String cognome;
	private String cf;
	private Date nascita;
	private Designatore designatore;
	private Arbitro arbitro;
	
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
	
	
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	
	@OneToOne(mappedBy="anagrafica")
	public Designatore getDesignatore() {
		return designatore;
	}
	public void setDesignatore(Designatore designatore) {
		this.designatore = designatore;
	}
	
	@OneToOne(mappedBy="anagrafica")
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	
	
	
}
