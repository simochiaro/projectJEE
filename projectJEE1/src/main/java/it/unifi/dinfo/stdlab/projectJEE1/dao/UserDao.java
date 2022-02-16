package it.unifi.dinfo.stdlab.projectJEE1.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import it.unifi.dinfo.stdlab.projectJEE1.model.User;

@RequestScoped
public class UserDao {
	@PersistenceUnit
	protected EntityManagerFactory entityManagerF=Persistence.createEntityManagerFactory("projectJEE1");
	protected EntityManager entityManager=entityManagerF.createEntityManager();
	
	
	@Inject public UserDao() {}
	
	
	public User findById(Long l) {
		return (User)  this.entityManager.createQuery("SELECT u FROM User u WHERE u.id= :id",User.class).setParameter("id", l).getSingleResult();
				//;
	}
	
	public List<User> list(){
		return this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	public User findByUsernameWithRoles(String principalusername) {
		return (User) this.entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username",User.class).setParameter("username", principalusername).getSingleResult();
	}

	
	public User findByUsername(String username) {
		return (User) this.entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username",User.class).setParameter("username", username).getSingleResult();
		
	}
}
