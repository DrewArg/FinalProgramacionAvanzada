package ar.edu.davinci.domain.clases;

import java.util.List;

import ar.edu.davinci.domain.interfaces.ModuloPagos;

public class Cliente implements ModuloPagos{

	private Membresia membresia;
	private List<Vehiculo> vehiculos;
	private Boolean tieneMora;
	private String dni;

	public Cliente(String dni, Membresia membresia) {
		this.membresia = membresia;
		this.tieneMora = false;
		this.dni = dni;
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

	public void setVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public Boolean getTieneMora() {
		return tieneMora;
	}

	public void setTieneMora(Boolean tieneMora) {
		this.tieneMora = tieneMora;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
}
