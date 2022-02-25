package it.unifi.dinfo.stdlab.projectSpark.model;



import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;



@Entity
@Table(name="Arbitri")
public class Arbitro {
	
	@OneToMany( targetEntity=Referto.class , mappedBy="arbitro")
	private List<Referto> referti;
	private Categoria categoria;
	private Boolean nuova_designazione;
	private Integer rifiuti;
	@OneToOne
	private Partita partita;
	
	@OneToOne
	private Anagrafica anagrafica;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	
	@OneToOne(mappedBy="arbitro")
	private Designazione designazione;
	
	@OneToOne(mappedBy="arbitro")
	private User user;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Designazione getDesignazione() {
		return designazione;
	}

	public void setDesignazione(Designazione designazione) {
		this.designazione = designazione;
	}

	
	public List<Referto> getReferti() {
		return referti;
	}

	public void setReferti(List<Referto> referti) {
		this.referti = referti;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}


	public Boolean getNuova_designazione() {
		return nuova_designazione;
	}

	public void setNuova_designazione(Boolean nuova_designazione) {
		this.nuova_designazione = nuova_designazione;
	}

	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}

	public Integer getRifiuti() {
		return rifiuti;
	}

	public void setRifiuti(Integer rifiuti) {
		this.rifiuti = rifiuti;
	}

	
	
}
