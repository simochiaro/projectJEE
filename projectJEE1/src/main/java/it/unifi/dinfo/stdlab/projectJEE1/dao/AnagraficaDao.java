package it.unifi.dinfo.stdlab.projectJEE1.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import it.unifi.dinfo.stdlab.projectJEE1.model.Anagrafica;

@RequestScoped
public class AnagraficaDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	public Anagrafica findById(long id) {
		return (Anagrafica) this.entityManager.createQuery("SELECT u FROM Anagrafica u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<Anagrafica> list(){
		return this.entityManager.createQuery("SELECT u FROM Anagrafica u", Anagrafica.class).getResultList();
	}
}
