package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Designazione;

@RequestScoped
public class DesignazioneDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Designazione findById(long id) {
		return (Designazione) this.entityManager.createQuery("SELECT u FROM Designazione u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Designazione> list(){
		return this.entityManager.createQuery("SELECT u FROM Designazione u", Designazione.class).getResultList();
	}
}