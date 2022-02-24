package it.unifi.dinfo.stdlab.projectJavalin.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.ebean.annotation.NotNull;


@Entity
@Table(name="Calendario")
public class Calendario {
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	private Long id;
	
	@OneToMany( targetEntity=Partita.class , mappedBy="calendario")
	private List<Partita> partite;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<Partita> getPartite() {
		return partite;
	}
	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}
	
	
}
