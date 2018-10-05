package modelo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignatura {

	private String nombre;
	private List<Calificacion> calificaciones = new ArrayList<Calificacion>();

	public Asignatura(String nombre) {
		this.nombre = nombre;
	}

	public void agregarCalificacion(Calificacion unaCalificacion) {
		//calificaciones.add(unaCalificacion);
	}

	public Calificacion getCalificacionActual() {
		return calificaciones.get(calificaciones.size() - 1);
	}

	public boolean estaAprobado() {
		return calificaciones.stream().allMatch(c -> c.estaAprobado());
	}

	// Getters and Setters

	public String getNombre() {
		return nombre;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
}
