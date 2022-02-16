package it.unifi.dinfo.stdlab.projectJEE1.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.unifi.dinfo.stdlab.projectJEE1.model.Arbitro;
import it.unifi.dinfo.stdlab.projectJEE1.model.Referto;

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

	public void creaReferto(Arbitro a,String esito, String amm, String esp) {
		Referto ref=new Referto();
		ref.setArbitro(a);
		ref.setAmm(amm);
		ref.setEsito(esito);
		ref.setPartita(a.getPartita());
		ref.setEsp(esp);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(ref);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}

	public Referto searchByTeam(Arbitro a,String casa, String ospite) {
		return (Referto) this.entityManager.createQuery("SELECT r FROM Referto r WHERE r.partita.casa.nome=:casa and r.partita.ospite.nome=:ospite and r.arbitro.id=:a", Referto.class).setParameter("casa",casa).setParameter("ospite",ospite).setParameter("a",a.getId()).getSingleResult();
		
	}

	public void generaSupplemento(Referto ref, String supplemento) {
		this.entityManager.getTransaction().begin();
	      Query query=this.entityManager.createQuery("UPDATE Referto r SET r.supplemento=:supplemento WHERE r.id= :id ").setParameter("supplemento", supplemento).setParameter("id", ref.getId());
	      query.executeUpdate();
	      this.entityManager.getTransaction().commit();
	      this.entityManager.close();
		
	}
}