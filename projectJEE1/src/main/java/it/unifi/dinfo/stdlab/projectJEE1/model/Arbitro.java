package it.unifi.dinfo.stdlab.projectJEE1.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="Arbitri")
public class Arbitro {
	private List<Referto> referti;
	private Categoria categoria;
	private Boolean nuova_designazione;
	private Anagrafica anagrafica;
	private Long id;
	private Designazione designazione;
	private User user;
	private Partita partita;
	private Integer rifiuti;
	
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	
	@OneToOne(mappedBy="arbitro",cascade = CascadeType.ALL, orphanRemoval = true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(mappedBy="arbitro")
	public Designazione getDesignazione() {
		return designazione;
	}

	public void setDesignazione(Designazione designazione) {
		this.designazione = designazione;
	}

	@OneToMany( targetEntity=Referto.class , mappedBy="arbitro")
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

	
	
	

	

	@OneToOne
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
	
	@OneToOne
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
