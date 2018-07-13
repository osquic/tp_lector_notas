package modelo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno {

	private String nombre;
	private String apellido;
	private String legajo;
	private String usuario;
	private List<Asignatura> asignaturas;

	public Alumno(String nombre, String apellido, String legajo, String usuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuario = usuario;
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public Alumno(String nombre, String apellido, String legajo, String usuario, List<Asignatura> asignaturas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuario = usuario;
		this.asignaturas = asignaturas;
	}

	public boolean aprueba(Asignatura asignatura) {
		return asignatura.estaAprobado();
	}

	public void agregarAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getLegajo() {
		return legajo;
	}

	public String getUsuario() {
		return usuario;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	@Override
	public String toString() {
		return nombre + ' ' + apellido;
	}

}
