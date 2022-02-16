package it.unifi.dinfo.stdlab.projectJEE1.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designazione;



@RequestScoped
public class ArbitroDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Arbitro findById(long id) {
		return (Arbitro) this.entityManager.createQuery("SELECT u FROM Arbitro u WHERE u.id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Arbitro> list(){
		return this.entityManager.createQuery("SELECT u FROM Arbitro u", Arbitro.class).getResultList();
	}

	public void connectDesignazione(Arbitro a) {
		Designazione des=  (Designazione)  this.entityManager.createQuery("SELECT u FROM Designazione u WHERE u.arbitro.id= :a AND u.accettata=false ",Designazione.class).setParameter("a", a.getId()).getSingleResult();
			
		a.setDesignazione(des);
		
	}

	
	public void accettaDesignazione(Arbitro a) {
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Arbitro a SET a.nuova_designazione=false , a.partita=:partita WHERE a.id= :a ").setParameter("a", a.getId()).setParameter("partita", a.getDesignazione().getPartita());
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
	}    
	
	  public void rifiutaDesignazione(Arbitro a) {
		  a.setNuova_designazione(false);
	      this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Arbitro a SET a.nuova_designazione=false WHERE a.id= :a  ").setParameter("a", a.getId());   
	  
		  query.executeUpdate();
		  this.entityManager.getTransaction().commit();
		  this.entityManager.close();	
		
	}

	public void disconnectPartita(Arbitro a) {
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Arbitro a SET a.partita=NULL  WHERE a.id= :id  ").setParameter("id", a.getId());   
	      
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}

	public void updateNuova(Arbitro a) {
		
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Arbitro a SET a.nuova_designazione=TRUE  WHERE a.id= :id  ").setParameter("id", a.getId());   
	      
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
	}

	

	

	
	
}