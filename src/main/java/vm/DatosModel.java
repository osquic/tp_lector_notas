package vm;

import org.uqbar.commons.utils.Observable;

import modelo.Alumno;
import repositorio.AlumnoRepositorio;

@Observable
public class DatosModel {

	private AlumnoRepositorio repo = AlumnoRepositorio.getInstance();
	private String legajoSeleccionado;
	private Alumno alumnoSeleccionado;

	private boolean permiteEditar = false;

	public void cargarDatosAlumnoSeleccionado() {
		alumnoSeleccionado = repo.getAlumno(legajoSeleccionado);
	}

	public void habilitarEdicion() {
		permiteEditar = true;
	}

	public void guardarDatos() {
		//repo.actualizarAlumno(alumnoSeleccionado);
	}

	// Getters y Setters
	public String getLegajoSeleccionado() {
		return legajoSeleccionado;
	}

	public void setLegajoSeleccionado(String legajo) {
		legajoSeleccionado = legajo;
	}

	public Alumno getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}

	public void setAlumnoSeleccionado(Alumno alumno) {
		alumnoSeleccionado = alumno;
	}

	public boolean getPermiteEditar() {
		return permiteEditar;
	}

	public void setPermiteEditar(boolean valor) {
		permiteEditar = valor;
	}

}