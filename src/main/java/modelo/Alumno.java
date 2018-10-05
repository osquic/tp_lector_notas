package modelo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
public class Alumno {

	@SerializedName("first_name") 
	private String nombre;
	@SerializedName("last_name") 
	private String apellido;
	@SerializedName("code") 
	private String legajo;
	@SerializedName("github_user") 
	private String usuarioGit;
	private List<Asignatura> asignaturas;

	public Alumno(String nombre, String apellido, String legajo, String usuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuarioGit = usuario;
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public Alumno(String nombre, String apellido, String legajo, String usuario, List<Asignatura> asignaturas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuarioGit = usuario;
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

	public String getUsuarioGit() {
		return usuarioGit;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsuario(String usuarioGit) {
		this.usuarioGit = usuarioGit;
	}

	@Override
	public String toString() {
		return nombre + ' ' + apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
