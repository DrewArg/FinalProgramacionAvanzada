package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Ubicacion;
import ar.edu.davinci.domain.clases.Vehiculo;

public class VehiculoService {

	List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	public void addVehiculo(String patente, Double toneladas) {
		vehiculos.add(new Vehiculo(patente, toneladas));
	}

	private Vehiculo buscarVehiculoByPatente(String patente) {

		Vehiculo resultado = null;

		for (Vehiculo vehiculo : vehiculos) {

			if (vehiculo.getPatente().equals(patente)) {

				resultado = vehiculo;
			}
		}

		return resultado;

	}

	public void setUbicacionVehiculo(String patente, Double longitud, Double latitud) {

		Vehiculo vehiculo = buscarVehiculoByPatente(patente);

		vehiculo.setUbicacion(new Ubicacion(longitud, latitud));
	}

	public Ubicacion getUbicacionVehiculo(String patente) {

		Vehiculo vehiculo = buscarVehiculoByPatente(patente);

		return vehiculo.getUbicacion();
	}

}
