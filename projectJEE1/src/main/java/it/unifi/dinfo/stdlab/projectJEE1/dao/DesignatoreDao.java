package it.unifi.dinfo.stdlab.projectJEE1.dao;


import java.sql.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designatore;
import it.unifi.dinfo.stdlab.projectJEE1.model.Designazione;
import it.unifi.dinfo.stdlab.projectJEE1.model.Partita;

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

	public List<Partita> findPartite(Designatore des) {
		return this.entityManager.createQuery("SELECT p FROM Partita p WHERE p.designata=false AND p.categoria=:categoria ",Partita.class).setParameter("categoria", des.getCategoria()).getResultList();
		
	}

	public void creaDesignazione(Designatore d,Arbitro a, Partita p, Date dat) {
		Designazione des=new Designazione();
		des.setAccettata(false);
		des.setArbitro(a);
		des.setData(dat);
		des.setDesignatore(d);
		des.setPartita(p);
		des.setRifiutata(false);
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(des);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
		
	}

	public Designazione controllaRifiuti(Designatore des) {
		Query query= this.entityManager.createQuery("SELECT d FROM Designazione d WHERE d.rifiutata=true AND d.designatore.id=:id ",Designazione.class).setParameter("id", des.getId());
		Designazione rifiuti=(Designazione) query.getSingleResult();
		return rifiuti;
	}

	public void ridesignaPartita(Designazione rifiuto, Long id) {
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Designazione d SET d.rifiutata=false , d.arbitro.id=:id WHERE d.id= :rifiuto ").setParameter("id", id).setParameter("rifiuto", rifiuto.getId());
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}

	public void aggiornaContatoreRifiuto(Designazione rifiuto) {
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Arbitro a SET a.rifiuti=a.rifiuti+1  WHERE a.id= :id ").setParameter("id", rifiuto.getArbitro().getId());
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}

	

	
}