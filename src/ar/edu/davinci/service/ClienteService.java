package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Cliente;
import ar.edu.davinci.domain.clases.Membresia;
import ar.edu.davinci.domain.clases.Problema;
import ar.edu.davinci.domain.clases.Vehiculo;
import ar.edu.davinci.domain.enumerados.TipoMembresia;
import ar.edu.davinci.domain.enumerados.TipoReparacion;

public class ClienteService {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ProblemaService problemaService = new ProblemaService();
	private MembresiaService membresiaService = new MembresiaService();

	public String addCliente(String dni, TipoMembresia tipoMembresia) {

		Membresia membresia = membresiaService.factoryMembresia(tipoMembresia);

		membresiaService.addMembresia(membresia);
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

	public String reportarProblema(String dni, String patente, String descripcion, TipoReparacion tipoReparacion) {

		String mensaje = null;

		Problema problema = problemaService.addAndReturnProblema(descripcion, tipoReparacion);

		Cliente cliente = buscarClienteByDni(dni);

		for (Vehiculo vehiculo : cliente.getVehiculos()) {

			if (vehiculo.getPatente().equalsIgnoreCase(patente)) {

				vehiculo.setProblema(problema);

				if (clienteCumpleAndSetTope(cliente, problema)) {

					mensaje = "Problema reportado correctamente";
				}

			} else {
				mensaje = "El cliente no tiene eses vehiculo en su poder.";
			}
		}

//		TODO : aca deberia llamar al metodo de la interfaz listener y pasarle la data

		return mensaje;
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

		} else if (cliente.getMembresia().getTipoMembresia() == TipoMembresia.ECONOMMIC
				&& cliente.getMembresia().getTopeReparaciones() > 0
				&& problema.getTipoReparacion() == TipoReparacion.REPARACION_SIMPLE) {

			cliente.getMembresia().setTopeReparaciones(cliente.getMembresia().getTopeReparaciones() - 1);

			resultado = true;

		}

		return resultado;
	}
}
