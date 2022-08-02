package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Vehiculo;

public class VehiculoService {

	private static VehiculoService instance;
	List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	private VehiculoService() {

	}

	public synchronized static VehiculoService getInstance() {
		if (instance == null) {
			instance = new VehiculoService();
		}

		return instance;
	}

	public void addVehiculo(String patente, Double toneladas) {
		Vehiculo vehiculo = new Vehiculo(patente, toneladas);

		vehiculos.add(vehiculo);

		System.out.println(vehiculo);
	}

	public Vehiculo buscarVehiculoByPatente(String patente) {

		Vehiculo resultado = null;

		for (Vehiculo vehiculo : vehiculos) {

			if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
				resultado = vehiculo;
			}
		}

		return resultado;

	}

}
