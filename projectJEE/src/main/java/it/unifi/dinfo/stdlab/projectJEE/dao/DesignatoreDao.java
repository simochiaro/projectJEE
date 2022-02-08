package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Designatore;

@RequestScoped
public class DesignatoreDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Designatore findById(long id) {
		return (Designatore) this.entityManager.createQuery("SELECT u FROM Designatore u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Designatore> list(){
		return this.entityManager.createQuery("SELECT u FROM Designatore u", Designatore.class).getResultList();
	}
}