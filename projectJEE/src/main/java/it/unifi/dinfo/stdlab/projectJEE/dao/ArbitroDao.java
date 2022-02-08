package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Arbitro;

@RequestScoped
public class ArbitroDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Arbitro findById(long id) {
		return (Arbitro) this.entityManager.createQuery("SELECT u FROM Arbitro u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Arbitro> list(){
		return this.entityManager.createQuery("SELECT u FROM Arbitro u", Arbitro.class).getResultList();
	}
}