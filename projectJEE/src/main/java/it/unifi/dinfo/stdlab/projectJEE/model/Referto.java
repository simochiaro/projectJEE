package it.unifi.dinfo.stdlab.projectJEE.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Referti")
public class Referto {
	private Arbitro arbitro;
	private Long id;
	private String esito;
	private Partita partita;
	private List<Giocatore> amm;
	
	
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
	
	@ManyToOne(targetEntity=Arbitro.class)
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
	
	@OneToMany( targetEntity=Giocatore.class , mappedBy="amm")
	public List<Giocatore> getAmm() {
		return amm;
	}
	public void setAmm(List<Giocatore> amm) {
		this.amm = amm;
	}
	
	
	
	
	
	
	
	
}
