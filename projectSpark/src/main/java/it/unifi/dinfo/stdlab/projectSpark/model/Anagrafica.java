package it.unifi.dinfo.stdlab.projectSpark.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;


@Entity
@Table(name="Anagrafica")
public class Anagrafica {
	private String nome;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	private String cognome;
	private String cf;
	private Date nascita;
	
	@OneToOne(mappedBy="anagrafica")
	private Designatore designatore;
	
	@OneToOne(mappedBy="anagrafica")
	private Arbitro arbitro;
	
	
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
