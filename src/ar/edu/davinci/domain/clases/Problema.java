package ar.edu.davinci.domain.clases;

import ar.edu.davinci.domain.enumerados.TipoReparacion;

public class Problema {

	private String descripcion;
	private Boolean requiereRemolque;
	private TipoReparacion tipoReparacion;

	/**
	 * si el tipo de reparacion es remolque o reparacion compleja, se deberia
	 * activar el flag de remolque
	 */

//	TODO : deberia haber un boolean problemaResuelto?

	public Problema(String descripcion, TipoReparacion tipoReparacion) {
		this.descripcion = descripcion;
		this.tipoReparacion = tipoReparacion;

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getRequiereRemolque() {
		return requiereRemolque;
	}

	public void setRequiereRemolque(Boolean requiereRemolque) {
		this.requiereRemolque = requiereRemolque;
	}

	public TipoReparacion getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(TipoReparacion tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}

	@Override
	public String toString() {
		return "Problema [descripcion=" + descripcion + ", requiereRemolque=" + requiereRemolque + ", tipoReparacion="
				+ tipoReparacion + "]";
	}

}
