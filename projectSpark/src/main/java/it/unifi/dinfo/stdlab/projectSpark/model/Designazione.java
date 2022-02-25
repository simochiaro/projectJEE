package it.unifi.dinfo.stdlab.projectSpark.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;

@Entity
@Table(name="Designazione")
public class Designazione {
	private Date data;
	
	@ManyToOne(targetEntity=Designatore.class)
	private Designatore designatore;
	private Boolean accettata;
	private Boolean rifiutata;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	
	@OneToOne
	private Arbitro arbitro;
	
	@OneToOne
	private Partita partita;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	public Boolean getAccettata() {
		return accettata;
	}
	public void setAccettata(Boolean accettata) {
		this.accettata = accettata;
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
	
	
	public Partita getPartita() {
		return partita;
	}
	
	
	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	public Boolean getRifiutata() {
		return rifiutata;
	}
	public void setRifiutata(Boolean rifiutata) {
		this.rifiutata = rifiutata;
	}
	
}
