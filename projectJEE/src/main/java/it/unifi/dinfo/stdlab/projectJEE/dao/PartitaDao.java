package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Partita;

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
}