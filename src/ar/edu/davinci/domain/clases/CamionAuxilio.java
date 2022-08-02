package ar.edu.davinci.domain.clases;

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
		for (Vehiculo vehiculo : pedidos) {
			if (vehiculo.getPatente().equals(patente)) {
				return vehiculo;
			}
		}
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

	public String getPatente() {
		return patente;
	}

	@Override
	public String toString() {
		return "CamionAuxilio [pedidos=" + pedidos + ", ubicacion=" + ubicacion + ", patente=" + patente + "]";
	}

}
