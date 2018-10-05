package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.Alumno;
import modelo.Asignatura;
import repositorio.AlumnoRepositorio;

@Observable
public class PrincipalModel {

	// Esto vale
	private AlumnoRepositorio repo = AlumnoRepositorio.getInstance();
	private String legajoIngresado;
	private String tokenIngresado;
	private boolean existeLegajo;

	public void chequearLegajo() {
		// TODO Auto-generated method stub
		// return null;
		legajoIngresado = repo.alumnoPorToken(tokenIngresado).getLegajo();
		existeLegajo = repo.existeLegajo(legajoIngresado);
	}

	// Getters y Setters
	public String getLegajoIngresado() {
		return legajoIngresado;
	}

	public void setLegajoIngresado(String legajo) {
		legajoIngresado = legajo;
	}
	
	public String getTokenIngresado() {
		return tokenIngresado;
	}

	public void setTokenIngresado(String tokenIngresado) {
		this.tokenIngresado = tokenIngresado;
	}

	public boolean getExisteLegajo() {
		return existeLegajo;
	}

	public void setExisteLegajo(boolean existe) {
		existeLegajo = existe;
	}

	private List<Alumno> alumnos;
	private Alumno alumnoElegido;
	private List<Asignatura> asignaturas;
	private String asignaturaElegida = "Hola";

	// Getters y Setters
	public List<Asignatura> getAsignaturas() {
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
