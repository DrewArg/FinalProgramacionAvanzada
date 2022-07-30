package ar.edu.davinci.domain;

public class Problema {

	private String descripcion;
	private Boolean requiereRemolque;
	private TipoServicio tipoReparacion;

	/**
	 *  si el tipo de reparacion es remolque o reparacion compleja, se deberia activar el flag de remolque
	 */

	public Problema(String descripcion, TipoServicio tipoReparacion) {
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

	public TipoServicio getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(TipoServicio tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}
}
