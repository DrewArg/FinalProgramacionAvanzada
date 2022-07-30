package ar.edu.davinci.domain.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Cliente;
import ar.edu.davinci.domain.clases.Membresia;
import ar.edu.davinci.domain.clases.Vehiculo;
import ar.edu.davinci.domain.enumerados.TipoMembresia;
import ar.edu.davinci.domain.enumerados.TipoReparacion;

public class ClienteService {

	private List<Cliente> clientes = new ArrayList();

	public String addCliente(String dni, Membresia membresia) {

		clientes.add(new Cliente(dni, membresia));

		return "Cliente agregado con exito";
	}

	public String asignarVehiculoCliente(String dni, Vehiculo vehiculo) {

		String mensaje = null;
		Cliente cliente = buscarClienteByDni(dni);

		if (cliente != null) {

			cliente.setVehiculo(vehiculo);

			mensaje = "Vehiculo agregado correctamente.";

		} else {

			mensaje = "No existe cliente con ese dni.";

		}

		return mensaje;

	}

	public String cambiarTipoMembresiaCliente(String dni, TipoMembresia tipoMembresia) {

		String mensaje = null;
		Cliente cliente = buscarClienteByDni(dni);
		
		if (cliente != null) {

			cliente.getMembresia().setTipoMembresia(tipoMembresia);

			mensaje = "Operacion realizada con exito.";
		} else {

			mensaje = "No existe un cliente con ese dni.";
		}

		return mensaje;
	}
	
	public void reportarProblema(String descripcion, TipoReparacion tipoReparacion) {

		
	}

	public Cliente buscarClienteByDni(String dni) {
		Cliente resultado = null;

		for (Cliente cliente : clientes) {

			if (cliente.getDni().equals(dni)) {

				resultado = cliente;
			}
		}

		return resultado;
	}
}
