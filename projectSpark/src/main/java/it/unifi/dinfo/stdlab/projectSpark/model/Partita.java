package it.unifi.dinfo.stdlab.projectSpark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;


@Entity
@Table(name="Partite")
public class Partita {
	
	@OneToOne(mappedBy="partita")
	private Referto referto;
	private String esito;
	private Boolean designata;
	
	@OneToOne(mappedBy="partita")
	private Arbitro arbitro;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	
	@OneToOne(mappedBy="partita")
	private Designazione designazione;
	
	@ManyToOne(targetEntity=Calendario.class)
	private Calendario calendario;
	
	@OneToOne
	private Squadra casa;
	
	@OneToOne
	private Squadra ospite;
	private Categoria categoria;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	
	
	public Referto getReferto() {
		return referto;
	}
	public void setReferto(Referto referto) {
		this.referto = referto;
	}
	
	
	public Designazione getDesignazione() {
		return designazione;
	}
	public void setDesignazione(Designazione designazione) {
		this.designazione = designazione;
	}
	
	
	public Calendario getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Boolean getDesignata() {
		return designata;
	}
	public void setDesignata(Boolean designata) {
		this.designata = designata;
	}
	
	
}
