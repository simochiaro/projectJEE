package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Giocatore;

@RequestScoped
public class GiocatoreDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Giocatore findById(long id) {
		return (Giocatore) this.entityManager.createQuery("SELECT u FROM Giocatore u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Giocatore> list(){
		return this.entityManager.createQuery("SELECT u FROM Giocatore u", Giocatore.class).getResultList();
	}
}