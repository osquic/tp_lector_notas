package modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {

	private String nombre;
	private List<Calificacion> calificaciones;

	public Asignatura(String nombre) {
		this.nombre = nombre;
		this.calificaciones = new ArrayList<Calificacion>();
	}

	public void agregarCalificacion(Calificacion unaCalificacion) {
		calificaciones.add(unaCalificacion);
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
