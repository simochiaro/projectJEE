package it.unifi.dinfo.stdlab.projectJEE1.rest.service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import it.unifi.dinfo.stdlab.projectJEE1.controller.ArbitroController;
import it.unifi.dinfo.stdlab.projectJEE1.controller.UserController;


@Path("arbitro")
public class ArbitroEndPoint {
	
	@GET
	@Path("nuovaDesignazione/{username}")
	@RolesAllowed("ARBITRO")
	public Response nuovaDesignazione(@PathParam("username") String username) {
		
		UserController userC=new UserController();
		
		return userC.nuovaDesignazione(username);
				
	}
	
	@PUT
	@Path("accettaDesignazione/{username}")
	@RolesAllowed("ARBITRO")
	public Response accettaDesignazione(@PathParam("username") String username) {
		
		UserController userC=new UserController();
		
		return userC.accettaDesignazione(username);
				
	}
	
	@PUT
	@Path("rifiutaDesignazione/{username}")
	@RolesAllowed("ARBITRO")
	public Response rifiutaDesignazione(@PathParam("username") String username) {
		
		UserController userC=new UserController();
		
		return userC.rifiutaDesignazione(username);
				
	}
	
	@PUT
	@Path("creaReferto/{username}/{esito}/{amm}/{esp}")
	@RolesAllowed("ARBITRO")
	public Response creaReferto(@PathParam("username") String username,@PathParam("esito") String esito,@PathParam("amm") String amm,@PathParam("esp") String esp) {
		
		ArbitroController aC=new ArbitroController();
		
		return aC.creaReferto(username,esito,amm,esp);
				
	}
	
	@GET
	@Path("ricercaReferto/{username}/{casa}/{ospite}")
	@RolesAllowed("ARBITRO")
	public Response creaReferto(@PathParam("username") String username,@PathParam("casa") String casa,@PathParam("ospite") String ospite) {
		
		ArbitroController aC=new ArbitroController();
		
		return aC.ricercaReferto(username,casa,ospite);
				
	}
	
	@PUT
	@Path("generaSupplemento/{username}/{casa}/{ospite}/{supplemento}")
	@RolesAllowed("ARBITRO")
	public Response supplementoReferto(@PathParam("username") String username,@PathParam("casa") String casa,@PathParam("ospite") String ospite,@PathParam("supplemento") String supplemento) {
		
		ArbitroController aC=new ArbitroController();
		
		return aC.supplementoReferto(username,casa,ospite,supplemento);
				
	}
}
