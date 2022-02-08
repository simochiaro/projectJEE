package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Squadra;

@RequestScoped
public class SquadraDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Squadra findById(long id) {
		return (Squadra) this.entityManager.createQuery("SELECT u FROM Squadra u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Squadra> list(){
		return this.entityManager.createQuery("SELECT u FROM Squadra u", Squadra.class).getResultList();
	}
}
