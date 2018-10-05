package vm;

import org.uqbar.commons.utils.Observable;

import modelo.Alumno;
import repositorio.AlumnoRepositorio;
import modelo.Api;
@Observable
public class DatosModel {
	
	Api api = new Api();

	private AlumnoRepositorio repo = AlumnoRepositorio.getInstance();
	private String legajoSeleccionado;
	private Alumno alumnoSeleccionado;
	private String tokenIngresado;

	public String getTokenIngresado() {
		return tokenIngresado;
	}

	public void setTokenIngresado(String tokenIngresado) {
		this.tokenIngresado = tokenIngresado;
	}

	private boolean siempreDisabled = false;

	private boolean permiteEditar = false;

	public void cargarDatosAlumnoSeleccionado() {
		alumnoSeleccionado = repo.getAlumno(legajoSeleccionado);
	}

	public void habilitarEdicion() {
		permiteEditar = true;
	}

	public void guardarDatos() {
		repo.actualizarAlumno(alumnoSeleccionado);
		api.putAlumnoPor(tokenIngresado, alumnoSeleccionado.getLegajo());
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
	
	public boolean getSiempreDisabled() {
		return siempreDisabled;
	}

	public void setSiempreDisabled(boolean siempreDisabled) {
		this.siempreDisabled = siempreDisabled;
	}

}