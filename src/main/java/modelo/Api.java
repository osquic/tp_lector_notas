package modelo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import repositorio.AlumnoRepositorio;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class Api {
	    private Client client;
	    private static final String URL = "http://notitas.herokuapp.com";
	    //private static final String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	    private static final String STUDENT = "student";
	    private static final String ASSIGNMENTS = "assignments";

	    //Inicializacion del cliente.
	    public Api() {
	        this.client = Client.create();
	    }

	    public ClientResponse getAlumno(String token){
	        WebResource recurso = this.client.resource(URL).path(STUDENT);
	        WebResource.Builder builder = recurso.accept(MediaType.APPLICATION_JSON)
	        		.header(HttpHeaders.AUTHORIZATION, "Bearer "+token);
	        ClientResponse response = builder.get(ClientResponse.class);
	        return response;
	    }
	    
	    public ClientResponse putAlumnoPor(String token, String legajo){
	    	String alumno = AlumnoRepositorio.getInstance().generarJSON(legajo); 
	        WebResource recurso = this.client.resource(URL).path(STUDENT);
	        WebResource.Builder builder = recurso.accept(MediaType.APPLICATION_JSON)
	        		.header(HttpHeaders.AUTHORIZATION, "Bearer "+token);
	        ClientResponse response = builder.put(ClientResponse.class, alumno);
	        return response;
	    }

	    public ClientResponse getAsignaciones(String token){
	        WebResource recurso = this.client.resource(URL).path(STUDENT).path(ASSIGNMENTS);
	        WebResource.Builder builder = recurso.accept(MediaType.APPLICATION_JSON)
	        		.header(HttpHeaders.AUTHORIZATION, "Bearer "+token);
	        ClientResponse response = builder.get(ClientResponse.class);
	        return response;
	    }
}
