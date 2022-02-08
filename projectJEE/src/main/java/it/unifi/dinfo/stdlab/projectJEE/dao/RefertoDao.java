package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.Referto;

@RequestScoped
public class RefertoDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Referto findById(long id) {
		return (Referto) this.entityManager.createQuery("SELECT u FROM Referto u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Referto> list(){
		return this.entityManager.createQuery("SELECT u FROM Referto u", Referto.class).getResultList();
	}
}