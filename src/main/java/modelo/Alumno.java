package modelo;

import java.util.Arrays;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno {

	public Alumno(String nombre, String apellido, String legajo, String usuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuario = usuario;
	}

	private String nombre;
	private String apellido;
	private String legajo;
	private String usuario;

	// private List<String> asignaturas;
	private List<String> asignaturas = Arrays.asList("Analisis 1", "Algebra", "Diseño de Sistemas");

	public List<String> getAsignaturas() {
		return asignaturas;
	}

	@Override
	public String toString() {
		return nombre + ' ' + apellido;
	}
}
