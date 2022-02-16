package it.unifi.dinfo.stdlab.projectJEE1.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designazione;


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
	
	public void accettaDesignazione(Arbitro a) {
		  this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Designazione d SET d.accettata=true WHERE d.arbitro.id= :a AND d.accettata=false ").setParameter("a", a.getId());
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
	      
	      
	}
	
	public void rifiutaDesignazione(Arbitro a) {
		
		  this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Designazione d SET d.rifiutata=true  WHERE d.arbitro.id= :id ").setParameter("id", a.getId());
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}

	
}