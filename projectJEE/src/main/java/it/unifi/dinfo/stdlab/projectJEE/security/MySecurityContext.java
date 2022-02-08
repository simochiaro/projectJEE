package it.unifi.dinfo.stdlab.projectJEE.security;

import java.security.Principal;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;

import it.unifi.dinfo.stdlab.projectJEE.dao.UserDao;
import it.unifi.dinfo.stdlab.projectJEE.model.User;

public class MySecurityContext implements javax.ws.rs.core.SecurityContext{
	@Inject 
	private UserDao userdao;
	private String principalusername;
	private ContainerRequestContext requestContext;
	
	public MySecurityContext(String principalUsername, ContainerRequestContext requestContext) {
		this.principalusername=principalUsername;
		this.requestContext=requestContext;
	}
	
	
	


	@Override 
	public boolean isUserInRole(String role) {
		User principal=userdao.findByUsernameWithRoles(principalusername);
		if(principal ==null)
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
