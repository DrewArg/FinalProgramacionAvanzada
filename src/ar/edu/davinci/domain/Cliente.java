package ar.edu.davinci.domain;

import java.util.List;

public class Cliente implements ModuloPagos{

	private Membresia membresia;
	private List<Vehiculo> vehiculos;
	private Boolean tieneMora;

	public Cliente(Membresia membresia, Boolean tieneMora) {
		this.membresia = membresia;
		this.tieneMora = tieneMora;
	}

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public Vehiculo getVehiculo(Integer index) {
		return vehiculos.get(index);
	}

	public void setVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public Boolean getTieneMora() {
		return tieneMora;
	}

	public void setTieneMora(Boolean tieneMora) {
		this.tieneMora = tieneMora;
	}
}
