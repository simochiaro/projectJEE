package it.unifi.dinfo.stdlab.projectJEE.security;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityRequestFilter implements ContainerRequestFilter{
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException{
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if(authorizationHeader == null || authorizationHeader.isEmpty()) {
			requestContext.abortWith(
					Response
						.status(Response.Status.UNAUTHORIZED)
						.entity("This request in UNAUTHORIZED")
						.type("text/plain")
						.build()
			);
		}
		
		String username=null;
		if(authorizationHeader.startsWith("Basic") || authorizationHeader.startsWith("BASIC")) {
			String base64Credentials = authorizationHeader.substring("Basic".length()).trim();
			byte[] bytes =Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(bytes, Charset.forName("UTF-8"));
			String[] tmp=credentials.split(":",2);
			username=tmp[0];
		}
		
		String principalUsername =username;
		
		requestContext.setSecurityContext(new MySecurityContext(principalUsername,requestContext));
	}
}
