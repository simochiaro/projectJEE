package it.unifi.dinfo.stdlab.projectJEE1.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Designatori")
public class Designatore {
	private Long id;
	private Anagrafica anagrafica;
	private Designazione designazione;
	private List<Partita> partita;
	private Categoria categoria;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id", nullable=false)
	@NotNull
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

	@OneToOne
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}
	
	@OneToOne( mappedBy="designatore")
	public Designazione getDesignazione() {
		return designazione;
	}

	public void setDesignazione(Designazione designazione) {
		this.designazione = designazione;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@OneToOne(mappedBy="designatore",cascade = CascadeType.ALL, orphanRemoval = true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(targetEntity=Partita.class, mappedBy="designatore")
	public List<Partita> getPartita() {
		return partita;
	}

	public void setPartita(List<Partita> partita) {
		this.partita = partita;
	}

	
	
	
	
	
	
}
