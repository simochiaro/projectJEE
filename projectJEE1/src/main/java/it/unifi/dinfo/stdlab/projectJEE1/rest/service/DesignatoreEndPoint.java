package it.unifi.dinfo.stdlab.projectJEE1.rest.service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import it.unifi.dinfo.stdlab.projectJEE1.controller.DesignatoreController;

@Path("designatore")
public class DesignatoreEndPoint {
	
	@PUT
	@Path("creaDesignazione/{username}/{idA}/{data}/{casa}/{ospite}")
	@RolesAllowed("DESIGNATORE")
	public Response creaDesignazione(@PathParam("username") String username,@PathParam("idA") String idA,@PathParam("data") String data,@PathParam("casa") String casa,@PathParam("ospite") String ospite) {
		
		DesignatoreController desC=new DesignatoreController();
		
		return desC.creaDesignazione(username,idA,data,casa,ospite);
				
	}
	@GET
	@Path("controllaRifiuti/{username}")
	@RolesAllowed("DESIGNATORE")
	public Response controllaRifiuti(@PathParam("username") String username) {
		
		DesignatoreController desC=new DesignatoreController();
		
		return desC.controllaRifiuti(username);
				
	}
	
	@PUT
	@Path("ridesignaPartita/{username}/{idA}")
	@RolesAllowed("DESIGNATORE")
	public Response ridesignaPartita(@PathParam("username") String username,@PathParam("idA") String idA) {
		
		DesignatoreController desC=new DesignatoreController();
		
		return desC.ridesignaPartita(username,idA);
				
	}
	
	@PUT
	@Path("contatoreRifiuto/{username}/")
	@RolesAllowed("DESIGNATORE")
	public Response contatoreRifiuto(@PathParam("username") String username) {
		
		DesignatoreController desC=new DesignatoreController();
		
		return desC.contatoreRifiuto(username);
				
	}
}
