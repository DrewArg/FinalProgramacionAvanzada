package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Vehiculo;

public class VehiculoService {

	List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

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
				System.out.println(resultado);

			}
		}

		return resultado;

	}

}
