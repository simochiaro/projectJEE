package it.unifi.dinfo.stdlab.projectJEE1.security;

import java.security.Principal;


import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;

import it.unifi.dinfo.stdlab.projectJEE1.model.User;
import it.unifi.dinfo.stdlab.projectJEE1.dao.UserDao;


public class MySecurityContext implements javax.ws.rs.core.SecurityContext{
	@Inject
	private UserDao userdao;
	
	private String password;
	private String principalusername;
	private ContainerRequestContext requestContext;
	
	public MySecurityContext(String principalUsername, String password, ContainerRequestContext requestContext) {
		this.principalusername=principalUsername;
		this.requestContext=requestContext;
		this.password=password;
	}
	
	
	


	@Override 
	public boolean isUserInRole(String role) {
		User principal=userdao.findByUsernameWithRoles(principalusername);
		
		if(principal ==null)
			return false;
		if(!this.password.equals(principal.getPassword())) 
			return false;
		if(!principal.isRolePresent(role))
			return false;
		
		return true;
	}
	
	@Override
	public Principal getUserPrincipal() {
		return new Principal() {
			@Override
			public String getName() {
				return principalusername;
			}
		};
	}
	
	@Override
	public boolean isSecure() {
		return requestContext.getSecurityContext().isSecure();
	}
	
	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}
}
