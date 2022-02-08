package it.unifi.dinfo.stdlab.projectJEE.model;


import java.util.List;


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
	private List<Designazione> designazione;
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
	
	@OneToMany( targetEntity=Designazione.class , mappedBy="designatore")
	public List<Designazione> getDesignazione() {
		return designazione;
	}

	public void setDesignazione(List<Designazione> designazione) {
		this.designazione = designazione;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@OneToOne(mappedBy="designatore")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
