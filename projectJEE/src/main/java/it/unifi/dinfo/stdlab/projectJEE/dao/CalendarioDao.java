package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Calendario;

@RequestScoped
public class CalendarioDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Calendario findById(long id) {
		return (Calendario) this.entityManager.createQuery("SELECT u FROM Calendario u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Calendario> list(){
		return this.entityManager.createQuery("SELECT u FROM Calendario u", Calendario.class).getResultList();
	}
}
