package it.unifi.dinfo.stdlab.projectSpark.model;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;


@Entity
@Table(name="Designatori")
public class Designatore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	
	@OneToOne
	private Anagrafica anagrafica;
	
	@OneToMany( targetEntity=Designazione.class , mappedBy="designatore")
	private List<Designazione> designazione;
	private Categoria categoria;
	
	@OneToOne(mappedBy="designatore")
	private User user;
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

	
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}
	
	
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
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
	
}
