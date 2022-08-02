package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Cliente;
import ar.edu.davinci.domain.clases.Membresia;
import ar.edu.davinci.domain.clases.Problema;
import ar.edu.davinci.domain.clases.Ubicacion;
import ar.edu.davinci.domain.clases.Vehiculo;
import ar.edu.davinci.domain.enumerados.TipoMembresia;
import ar.edu.davinci.domain.enumerados.TipoReparacion;
import ar.edu.davinci.domain.interfaces.Listener;

public class ClienteService {

	private static ClienteService instance;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ProblemaService problemaService = ProblemaService.getInstance();
	private MembresiaService membresiaService = MembresiaService.getInstance();

	private ClienteService() {

	}

	public synchronized static ClienteService getInstance() {
		if (instance == null) {
			instance = new ClienteService();
		}

		return instance;
	}

	public void addCliente(String dni, TipoMembresia tipoMembresia) {

		Membresia membresia = membresiaService.addMembresia(tipoMembresia);
		Cliente cliente = new Cliente(dni, membresia);

		clientes.add(cliente);

		System.out.println(cliente);
	}

	public void asignarVehiculoCliente(String dni, Vehiculo vehiculo) {

		String mensaje = null;
		Cliente cliente = buscarClienteByDni(dni);

		if (cliente != null) {

			cliente.setVehiculo(vehiculo);

			mensaje = "Vehiculo agregado correctamente.";

		} else {

			mensaje = "No existe cliente con ese dni.";

		}
		System.out.println(cliente);
		System.out.println(mensaje);
	}

	public void cambiarTipoMembresiaCliente(String dni, TipoMembresia tipoMembresia) {

		String mensaje = null;
		Cliente cliente = buscarClienteByDni(dni);

		if (cliente != null) {

			cliente.getMembresia().setTipoMembresia(tipoMembresia);

			mensaje = "Operacion realizada con exito.";
		} else {

			mensaje = "No existe un cliente con ese dni.";
		}

		System.out.println(mensaje);
	}

	public void reportarProblema(String dni, String patente, String descripcion, TipoReparacion tipoReparacion,
			Double longitud, Double latitud) {

		String mensaje = null;

		Problema problema = problemaService.addAndReturnProblema(descripcion, tipoReparacion);

		Cliente cliente = buscarClienteByDni(dni);

		for (Vehiculo vehiculo : cliente.getVehiculos()) {

			if (vehiculo.getPatente().equalsIgnoreCase(patente)) {

				vehiculo.setProblema(problema);
				vehiculo.setUbicacion(new Ubicacion(longitud, latitud));

				if (clienteCumpleAndSetTope(cliente, problema)) {

					Listener.asignarCamion(cliente, vehiculo);

					mensaje = "Problema reportado correctamente";
				} else {

					mensaje = "La membresia del cliente no cubre este tipo de servicios";
				}

			} else {

				mensaje = "El cliente no tiene eses vehiculo en su poder.";
			}
		}

		System.out.println(mensaje);
	}

	private Cliente buscarClienteByDni(String dni) {

		Cliente resultado = null;

		for (Cliente cliente : clientes) {

			if (cliente.getDni().equals(dni)) {

				resultado = cliente;
			}
		}

		return resultado;
	}

	private Boolean clienteCumpleAndSetTope(Cliente cliente, Problema problema) {

		Boolean resultado = false;

		if (cliente.getMembresia().getTipoMembresia() == TipoMembresia.CLASSIC && problema.getRequiereRemolque()
				&& cliente.getMembresia().getTopeRemolques() > 0) {

			cliente.getMembresia().setTopeRemolques(cliente.getMembresia().getTopeRemolques() - 1);

			resultado = true;

		} else if (cliente.getMembresia().getTipoMembresia() == TipoMembresia.CLASSIC
				&& problema.getTipoReparacion() == TipoReparacion.REPARACION_SIMPLE) {

			resultado = true;

		} else if (cliente.getMembresia().getTipoMembresia() == TipoMembresia.ECONOMMIC
				&& cliente.getMembresia().getTopeReparaciones() > 0
				&& problema.getTipoReparacion() == TipoReparacion.REPARACION_SIMPLE) {

			cliente.getMembresia().setTopeReparaciones(cliente.getMembresia().getTopeReparaciones() - 1);

			resultado = true;

		} else if (cliente.getMembresia().getTipoMembresia() == TipoMembresia.PLATINUM) {

			resultado = true;

		}

		return resultado;
	}
}
