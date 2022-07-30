package ar.edu.davinci.domain.clases;

import java.util.List;

import ar.edu.davinci.domain.interfaces.ModuloPagos;

public class Cliente implements ModuloPagos{

	private Membresia membresia;
	private List<Vehiculo> vehiculos;
	private Boolean tieneMora;

	public Cliente(Membresia membresia) {
		this.membresia = membresia;
		this.tieneMora = false;
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

	public Vehiculo getVehiculo(Integer index) { //string con ID / patente y devuelve el que se necesita
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
