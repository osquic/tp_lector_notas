package repositorio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Calificacion;
import modelo.TipoCalificacion;
import modelo.Api;

public class AlumnoRepositorio {

	private static AlumnoRepositorio instancia;
	private Api request = new Api();

	private AlumnoRepositorio() {
		Alumno a1 = new Alumno("Kevin", "Gio", "123", "notengogit");
		Alumno a2 = new Alumno("Jorgito", "Suh", "1234", "noentendogit");
		Alumno a3 = new Alumno("Gabi", "Nose", "12345", "ojitoaSUHlado");
		Alumno api = new Alumno("unNombre", "unApellido", "111222333", "usuarioGit");
		alumnos = new ArrayList<Alumno>();
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(api);
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.NUMERICA, "7");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		
//		Asignatura dds = new Asignatura("DDS");
//		Calificacion calificacionDDS1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M");
//		Calificacion calificacionDDS2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "R+");
//		Calificacion calificacionDDS3 = new Calificacion(TipoCalificacion.NUMERICA, "2");
//		dds.agregarCalificacion(calificacionDDS1);
//		dds.agregarCalificacion(calificacionDDS2);
//		dds.agregarCalificacion(calificacionDDS3);
//		
//		a1.agregarAsignatura(matematica);
//		a1.agregarAsignatura(dds);
//		a2.agregarAsignatura(dds);
		
	}

	public static AlumnoRepositorio getInstance() {
		if (instancia == null) {
			instancia = new AlumnoRepositorio();
		}
		return instancia;
	}
	
	public String generarJSON(String legajo) {
		Alumno alumno = this.getAlumno(legajo);
		Gson alumnojson = new Gson();
		String jsonoutput = alumnojson.toJson(alumno, Alumno.class);
		return jsonoutput;
	}
	
	public Alumno alumnoPorToken(String token) {
		ClientResponse response = request.getAlumno(token);
        String json = response.getEntity(String.class);
        Gson alumnoJson = new Gson();
        Alumno unAlumno = alumnoJson.fromJson(json, Alumno.class);
        return unAlumno;
	}

	private List<Alumno> alumnos;

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public boolean existeLegajo(String legajo) {
		return alumnos.stream().anyMatch(a -> a.getLegajo().equals(legajo));
	}

	public Alumno getAlumno(String legajo) {
		return alumnos.stream().filter(a -> a.getLegajo().equals(legajo)).findFirst().get();
	}
	
	public void actualizarAlumno(Alumno unAlumno) {
		Alumno actualizar = this.getAlumno(unAlumno.getLegajo());
		actualizar.setNombre(unAlumno.getNombre());
		actualizar.setUsuario(unAlumno.getUsuarioGit());
		actualizar.setApellido(unAlumno.getApellido());
	}

}
