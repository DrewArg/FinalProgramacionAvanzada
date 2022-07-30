package ar.edu.davinci.domain;

import java.util.List;

public abstract class Membresia {

	// private List<TipoServicio> servicios;
	private Integer topeReparaciones;
	private Integer topeRemolques;
	private TipoMembresia tipoMembresia;

	public Membresia(TipoMembresia tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
		// cuando se crea la membresia depende el tipo de membresia se asignan distintos
		// topes y se crea la membresia correspondiente
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
