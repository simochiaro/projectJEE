package it.unifi.dinfo.stdlab.projectJEE.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@Id
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
	
	
	public Boolean getAccettata() {
		return accettata;
	}
	public void setAccettata(Boolean accettata) {
		this.accettata = accettata;
	}
	
	@ManyToOne(targetEntity=Designatore.class)
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
