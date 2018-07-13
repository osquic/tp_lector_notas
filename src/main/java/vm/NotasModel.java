package vm;

import java.util.List;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Calificacion;
import repositorio.AlumnoRepositorio;

public class NotasModel {

	private AlumnoRepositorio repo = AlumnoRepositorio.getInstance();
	private String legajoSeleccionado;
	private Alumno alumnoSeleccionado;
	private List<Asignatura> asignaturas;
	private Asignatura asignaturaSeleccionada;
	private Calificacion calificacion;
	private String estado;

	public void cargarDatosAlumnoSeleccionado() {
		alumnoSeleccionado = repo.getAlumno(legajoSeleccionado);
		asignaturas = alumnoSeleccionado.getAsignaturas();
	}

	public AlumnoRepositorio getRepo() {
		return repo;
	}

	public void setRepo(AlumnoRepositorio repo) {
		this.repo = repo;
	}

	public String getLegajoSeleccionado() {
		return legajoSeleccionado;
	}

	public void setLegajoSeleccionado(String legajoSeleccionado) {
		this.legajoSeleccionado = legajoSeleccionado;
	}

	public Alumno getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}

	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
		this.alumnoSeleccionado = alumnoSeleccionado;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Asignatura getAsignaturaSeleccionada() {
		return asignaturaSeleccionada;
	}

	public void setAsignaturaSeleccionada(Asignatura asignaturaSeleccionada) {
		this.asignaturaSeleccionada = asignaturaSeleccionada;
		this.setCalificacion(asignaturaSeleccionada.getCalificacionActual());
		this.setEstado(devolverEstado());
	}

	private String devolverEstado() {
		if (asignaturaSeleccionada.estaAprobado()) {
			return "Aprobado";
		} else {
			return "No aprobado";
		}
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
