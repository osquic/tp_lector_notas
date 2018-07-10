package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;

public class AlumnoRepositorio {

	private static AlumnoRepositorio instancia;

	private AlumnoRepositorio() {
		Alumno a1 = new Alumno("Kevin", "Gio", "123456", "notengogit");
		Alumno a2 = new Alumno("Jorgito", "Suh", "123123", "noentendogit");
		Alumno a3 = new Alumno("Gabi", "Nose", "121212", "ojitoaSUHlado");
		alumnos = new ArrayList<Alumno>();
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
	}

	// hacer singleton getInstance()
	public static AlumnoRepositorio getInstance() {
		if (instancia == null) {
			instancia = new AlumnoRepositorio();
		}
		return instancia;
	}

	private List<Alumno> alumnos;

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

}
