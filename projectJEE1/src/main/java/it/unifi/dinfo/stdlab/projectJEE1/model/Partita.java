package it.unifi.dinfo.stdlab.projectJEE1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Partite")
public class Partita {
	private Referto referto;
	private String esito;
	private Long id;
	private Designazione designazione;
	private Calendario calendario;
	private Squadra casa;
	private Squadra ospite;
	private Categoria categoria;
	private Arbitro arbitro;
	private Designatore designatore;
	private Boolean designata;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
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
	
	@OneToOne(mappedBy="partita")
	public Referto getReferto() {
		return referto;
	}
	public void setReferto(Referto referto) {
		this.referto = referto;
	}
	
	@OneToOne(mappedBy="partita")
	public Designazione getDesignazione() {
		return designazione;
	}
	public void setDesignazione(Designazione designazione) {
		this.designazione = designazione;
	}
	
	@ManyToOne(targetEntity=Calendario.class)
	public Calendario getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
	@OneToOne
	public Squadra getCasa() {
		return casa;
	}
	public void setCasa(Squadra casa) {
		this.casa = casa;
	}
	
	@OneToOne
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
	
	@OneToOne(mappedBy="partita")
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	@ManyToOne( targetEntity=Designatore.class )
	public Designatore getDesignatore() {
		return designatore;
	}
	public void setDesignatore(Designatore designatore) {
		this.designatore = designatore;
	}
	public Boolean getDesignata() {
		return designata;
	}
	public void setDesignata(Boolean designata) {
		this.designata = designata;
	}
	
	
}
