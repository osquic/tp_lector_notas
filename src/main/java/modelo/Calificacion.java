package modelo;

import org.uqbar.commons.utils.Observable;

@Observable
public class Calificacion {

	private TipoCalificacion tipoCalificacion;
	private String calificacion;

	public Calificacion(TipoCalificacion tipoCalificacion, String calificacion) {
		this.tipoCalificacion = tipoCalificacion;
		this.calificacion = calificacion;
	}

	public TipoCalificacion getTipoCalificacion() {
		return tipoCalificacion;
	}

	// public boolean estaAprobado() {
	// return getCalificacionNumerica() >= 6 ||
	// !getCalificacionConceptual().contains("M");
	// }
	public boolean estaAprobado() {
		if (tipoCalificacion == TipoCalificacion.NUMERICA) {
			return getCalificacionNumerica() >= 6;
		}
		return !getCalificacionConceptual().contains("M");
	}

	/* Opcion 1 */
	public String getCalificacion() {
		return calificacion;
	}

	/* Opcion 2 */
	public String getCalificacionConceptual() {
		return calificacion;
	}

	public int getCalificacionNumerica() {
		return Integer.parseInt(calificacion);
	}

}
