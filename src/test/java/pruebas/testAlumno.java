package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Calificacion;
import modelo.TipoCalificacion;

class testAlumno {

	@Test
	void testCrearAsignatura() {
		Asignatura matematica = new Asignatura("Matematica");
		assertNotNull(matematica);
	}

	@Test
	void testConsultarNombreAsignaturaCreada() {
		Asignatura matematica = new Asignatura("Matematica");
		assertEquals(matematica.getNombre(), "Matematica");
	}

	@Test
	void testCrearNotaNumerica() {

		Calificacion calificacion = new Calificacion(TipoCalificacion.NUMERICA, "9");
		assertEquals(calificacion.getCalificacion(), "9");
	}

	@Test
	void testCrearNotaConceptual() {

		Calificacion calificacion = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		assertEquals(calificacion.getCalificacion(), "M+");
	}

	@Test
	void testAsignaturaSinCalificacion() {
		Asignatura matematica = new Asignatura("Matematica");
		assertEquals(matematica.getCalificaciones().size(), 0);
	}

	@Test
	void testAsignaturaAgregarCalificacion() {
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		matematica.agregarCalificacion(calificacion);
		assertEquals(matematica.getCalificaciones().size(), 1);
	}

	@Test
	void testAsignaturaUltimaCalificacionCorrecta() {
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		assertEquals(matematica.getCalificacionActual(), calificacion3);
	}

	@Test
	void testAsignaturaUltimaCalificacionIncorrecta() {
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M+");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		assertNotEquals(matematica.getCalificacionActual(), calificacion2);
	}

	@Test
	void testCalificacionConceptualAprobada() {
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B+");
		assertTrue(calificacion1.estaAprobado());
	}

	@Test
	void testCalificacionConceptualDesaprobada() {
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M");
		assertFalse(calificacion1.estaAprobado());
	}

	@Test
	void testAsignaturaAprobada() {
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "R+");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.NUMERICA, "10");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		assertTrue(matematica.estaAprobado());
	}

	@Test
	void testAsignaturaDesaprobada() {
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "R+");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.NUMERICA, "2");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		assertFalse(matematica.estaAprobado());
	}

	@Test
	void testAsignaturaDesaprobada2() {
		Asignatura matematica = new Asignatura("Matematica");
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "M");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.NUMERICA, "10");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		assertFalse(matematica.estaAprobado());
	}

	@Test
	void testAlumnoConAsignatura() {
		Asignatura matematica = new Asignatura("Matematica");
		Alumno kevin = new Alumno("Kevin", "Gio", "123456", "notengogit");
		kevin.agregarAsignatura(matematica);
		assertEquals(kevin.getAsignaturas().size(), 1);
	}

	@Test
	void testAlumnoApruebaAsignatura() {
		Calificacion calificacion1 = new Calificacion(TipoCalificacion.CONCEPTUAL, "B");
		Calificacion calificacion2 = new Calificacion(TipoCalificacion.CONCEPTUAL, "R+");
		Calificacion calificacion3 = new Calificacion(TipoCalificacion.NUMERICA, "10");
		Asignatura matematica = new Asignatura("Matematica");
		matematica.agregarCalificacion(calificacion1);
		matematica.agregarCalificacion(calificacion2);
		matematica.agregarCalificacion(calificacion3);
		Alumno kevin = new Alumno("Kevin", "Gio", "123456", "notengogit");
		kevin.agregarAsignatura(matematica);
		assertTrue(kevin.aprueba(matematica));
	}

}
