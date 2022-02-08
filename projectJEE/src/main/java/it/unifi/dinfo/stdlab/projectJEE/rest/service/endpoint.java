package it.unifi.dinfo.stdlab.projectJEE.rest.service;

import javax.ws.rs.Produces;
import javax.annotation.security.RolesAllowed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;



import javax.ws.rs.core.MediaType;

@Path("endpoint")
public class endpoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("ARBITRO")
	public Response ping() {
		
		return Response
				.ok()
				.entity("the server is online")
				.build();
				
	}
}
