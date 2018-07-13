package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;

public class AlumnoRepositorio {

	private static AlumnoRepositorio instancia;

	private AlumnoRepositorio() {
		Alumno a1 = new Alumno("Kevin", "Gio", "123", "notengogit");
		Alumno a2 = new Alumno("Jorgito", "Suh", "1234", "noentendogit");
		Alumno a3 = new Alumno("Gabi", "Nose", "12345", "ojitoaSUHlado");
		alumnos = new ArrayList<Alumno>();
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
	}

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

	public boolean existeLegajo(String legajo) {
		return alumnos.stream().anyMatch(a -> a.getLegajo().equals(legajo));
	}

	public Alumno getAlumno(String legajo) {
		return alumnos.stream().filter(a -> a.getLegajo().equals(legajo)).findFirst().get();
	}

}
