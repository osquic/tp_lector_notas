package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.Alumno;
import repositorio.AlumnoRepositorio;

@Observable
public class PrincipalModel {

	private List<Alumno> alumnos;
	private Alumno alumnoElegido;
	// private List<String> asignaturas = alumnoElegido.getAsignaturas();
	private List<String> asignaturas;
	private String asignaturaElegida = "Hola";

	// Getters y Setters
	public List<String> getAsignaturas() {
		return asignaturas;
	}

	public List<Alumno> getAlumnos() {
		return AlumnoRepositorio.getInstance().getAlumnos();
	}

	public Alumno getAlumnoElegido() {
		return alumnoElegido;
	}

	public String getAsignaturaElegida() {
		return asignaturaElegida;
	}

	public void setAsignaturaElegida(String asignatura) {
		asignaturaElegida = asignatura;
	}

	public void setAlumnoElegido(Alumno alumno) {
		alumnoElegido = alumno;
		asignaturas = alumno.getAsignaturas();
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
