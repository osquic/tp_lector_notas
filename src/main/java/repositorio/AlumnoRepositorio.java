package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Calificacion;
import modelo.TipoCalificacion;

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
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.NUMERICA, "7");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		
//		Asignatura dds = new Asignatura("DDS");
//		Calificacion calificacionDDS1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M");
//		Calificacion calificacionDDS2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "R+");
//		Calificacion calificacionDDS3 = new Calificacion(TipoCalificacion.NUMERICA, "2");
//		dds.agregarCalificacion(calificacionDDS1);
//		dds.agregarCalificacion(calificacionDDS2);
//		dds.agregarCalificacion(calificacionDDS3);
//		
//		a1.agregarAsignatura(matematica);
//		a1.agregarAsignatura(dds);
//		a2.agregarAsignatura(dds);
		
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
