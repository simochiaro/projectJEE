package it.unifi.dinfo.stdlab.projectJEE.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.dinfo.stdlab.projectJEE.model.User;

@RequestScoped
public class UserDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public User findById(long id) {
		return (User) this.entityManager.createQuery("SELECT u FROM User u WHERE u:id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	public List<User> list(){
		return this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	public User findByUsernameWithRoles(String principalusername) {
		return (User) this.entityManager.createQuery("SELECT u FROM User u WHERE u:username=:username").setParameter("username", principalusername).getSingleResult();
		
	}
}
