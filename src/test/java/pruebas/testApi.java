package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import modelo.Api;
import repositorio.AlumnoRepositorio;

public class testApi {

	Api requester;
	String token;

    @Before
    public void setUp() throws Exception {
        this.requester = new Api();
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
    }

    @Test
    public void conectaConApi() throws Exception {
        ClientResponse response = this.requester.getAlumno(token);
        assertEquals(response.getStatus(), 200);
        String json = response.getEntity(String.class);
        assertTrue(json.contains("github_user"));
        assertTrue(json.contains("code"));
    }
    
    @Test
    public void test() throws Exception {
    	ClientResponse response = this.requester.putAlumnoPor(token, "111222333");
        assertEquals(response.getStatus(), 201);
    }
}
