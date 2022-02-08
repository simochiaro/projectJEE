package it.unifi.dinfo.stdlab.projectJEE.dto;



import it.unifi.dinfo.stdlab.projectJEE.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE.model.Partita;

public class DesignazioneDto {

	private Long id;
	private Arbitro arbitro;
	private Partita partita;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	public Partita getPartita() {
		return partita;
	}
	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	
	
}
