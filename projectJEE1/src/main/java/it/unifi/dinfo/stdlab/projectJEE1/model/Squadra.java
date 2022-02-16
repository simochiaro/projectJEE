package it.unifi.dinfo.stdlab.projectJEE1.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Squadre")
public class Squadra {
	private String nome;
	private Partita casa;
	private Partita ospite;
	private Long id;
	private String giocatori;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToOne(mappedBy="casa")
	public Partita getCasa() {
		return casa;
	}
	public void setCasa(Partita casa) {
		this.casa = casa;
	}
	
	@OneToOne(mappedBy="ospite")
	public Partita getOspite() {
		return ospite;
	}
	public void setOspite(Partita ospite) {
		this.ospite = ospite;
	}
	public String getGiocatori() {
		return giocatori;
	}
	public void setGiocatori(String giocatori) {
		this.giocatori = giocatori;
	}
	
	
	
	
	
}
