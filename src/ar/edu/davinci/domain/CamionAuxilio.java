package ar.edu.davinci.domain;

import java.util.List;

public abstract class CamionAuxilio {

	private List<Vehiculo> pedidos;
	private Ubicacion ubicacion;
	private String patente;

	public CamionAuxilio(Ubicacion ubicacion, String patente) {
		this.ubicacion = ubicacion;
		this.patente = patente;
	}

	public List<Vehiculo> getPedidos() {
		return pedidos;
	}

	public Vehiculo getPedido(String patente) {
		// return pedidos.get(index);
		//TODO : logica para buscar por patente
		return null;
	}

	public void addPedido(Vehiculo pedido) {
		pedidos.add(pedido);
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getPatente(){
		return patente;
	}

}
