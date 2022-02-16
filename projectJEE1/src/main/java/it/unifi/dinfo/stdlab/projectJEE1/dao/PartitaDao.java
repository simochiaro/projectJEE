package it.unifi.dinfo.stdlab.projectJEE1.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.unifi.dinfo.stdlab.projectJEE1.model.Partita;

@RequestScoped
public class PartitaDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Partita findById(long id) {
		return (Partita) this.entityManager.createQuery("SELECT u FROM Partita u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Partita> list(){
		return this.entityManager.createQuery("SELECT u FROM Partita u", Partita.class).getResultList();
	}

	public void esitoPartita(Partita partita,String esito) {
		  this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Partita p SET p.esito=:esito  WHERE p.id= :id  ").setParameter("esito",esito).setParameter("id", partita.getId());   
	      
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}

	public Partita findPartita(List<Partita> partita,String casa, String ospite) {
		Partita result=null;
		for (Partita p : partita) {
			if(p.getCasa().getNome().equals(casa)) {
				if(p.getOspite().getNome().equals(ospite))
					result=p;
			}		
		}
		return result;
	}

	public void updatePartita(Partita p) {
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Partita p SET p.designata=true  WHERE p.id= :id  ").setParameter("id", p.getId());   
	      
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}
}