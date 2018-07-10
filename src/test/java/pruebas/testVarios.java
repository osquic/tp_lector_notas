package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Alumno;
import repositorio.AlumnoRepositorio;

class testVarios {

	@Test
	void testCrearAlumno() {
		Alumno alumno = new Alumno("Kevin", "Gio", "123456", "notengogit");
		assertNotNull(alumno);
	}

	@Test
	void testCrearListaVacia() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		assertNotNull(alumnos);
	}

	@Test
	void testAgregarAlumnoALista() {
		Alumno alumno = new Alumno("Kevin", "Gio", "123456", "notengogit");
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(alumno);
		assertTrue(alumnos.size() == 1);
	}

	@Test
	void testRepo() {
		List<Alumno> alumnos = AlumnoRepositorio.getInstance().getAlumnos();
		assertTrue(alumnos.size() != 0);
	}

}
