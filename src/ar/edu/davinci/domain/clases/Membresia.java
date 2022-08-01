package ar.edu.davinci.domain.clases;

import ar.edu.davinci.domain.enumerados.TipoMembresia;

public abstract class Membresia {

	private Integer topeReparaciones;
	private Integer topeRemolques;
	private TipoMembresia tipoMembresia;

	public Membresia(TipoMembresia tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}

	public Integer getTopeReparaciones() {
		return topeReparaciones;
	}

	public void setTopeReparaciones(Integer topeReparaciones) {
		this.topeReparaciones = topeReparaciones;
	}

	public Integer getTopeRemolques() {
		return topeRemolques;
	}

	public void setTopeRemolques(Integer topeRemolques) {
		this.topeRemolques = topeRemolques;
	}

	public TipoMembresia getTipoMembresia() {
		return tipoMembresia;
	}

	public void setTipoMembresia(TipoMembresia tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}

}
