package it.unifi.dinfo.stdlab.projectJEE1.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Designazione")
public class Designazione {
	private Date data;
	private Designatore designatore;
	private Boolean accettata;
	private Long id;
	private Arbitro arbitro;
	private Partita partita;
	private Boolean rifiutata;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name ="id", nullable=false)
	@NotNull
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
	
	
	public Boolean getRifiutata() {
		return rifiutata;
	}
	public void setRifiutata(Boolean rifiutata) {
		this.rifiutata = rifiutata;
	}
	public Boolean getAccettata() {
		return accettata;
	}
	public void setAccettata(Boolean accettata) {
		this.accettata = accettata;
	}
	
	@OneToOne
	public Designatore getDesignatore() {
		return designatore;
	}
	public void setDesignatore(Designatore designatore) {
		this.designatore = designatore;
	}
	
	@OneToOne
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	@OneToOne
	public Partita getPartita() {
		return partita;
	}
	
	
	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	
}
