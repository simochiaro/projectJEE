package it.unifi.dinfo.stdlab.projectJEE1.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private String amm;
	private String esp;
	private String supplemento;
	
	
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
	public String getAmm() {
		return amm;
	}
	public void setAmm(String amm) {
		this.amm = amm;
	}
	public String getEsp() {
		return esp;
	}
	public void setEsp(String esp) {
		this.esp = esp;
	}
	public String getSupplemento() {
		return supplemento;
	}
	public void setSupplemento(String supplemento) {
		this.supplemento = supplemento;
	}
	
	
	
	
	
	
	
	
	
	
}
