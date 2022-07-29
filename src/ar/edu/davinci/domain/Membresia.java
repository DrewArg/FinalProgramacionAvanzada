package ar.edu.davinci.domain;

import java.util.List;

public abstract class Membresia {

	private List<TipoServicio> servicios;

	public Membresia() {
	}

	public List<TipoServicio> getServicios() {
		return servicios;
	}

	public TipoServicio getServicio(Integer index) {
		return servicios.get(index);
	}

	public void setServicio(TipoServicio servicio) {
		servicios.add(servicio);
	}
}
