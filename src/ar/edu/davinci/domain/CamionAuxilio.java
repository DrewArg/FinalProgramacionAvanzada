package ar.edu.davinci.domain;

import java.util.List;

public abstract class CamionAuxilio {

	private List<Vehiculo> pedidos;
	private Ubicacion ubicacion;

	public CamionAuxilio(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Vehiculo> getPedidos() {
		return pedidos;
	}

	public Vehiculo getPedido(Integer index) {
		return pedidos.get(index);
	}

	public void setPedidos(Vehiculo pedido) {
		pedidos.add(pedido);
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

}
