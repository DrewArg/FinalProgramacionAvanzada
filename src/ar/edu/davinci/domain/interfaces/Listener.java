package ar.edu.davinci.domain.interfaces;

import ar.edu.davinci.domain.clases.CamionAuxilio;
import ar.edu.davinci.domain.clases.Cliente;
import ar.edu.davinci.domain.clases.Vehiculo;
import ar.edu.davinci.service.CamionAuxilioService;

public interface Listener {
	public static void asignarCamion(Cliente cliente, Vehiculo vehiculo) {

		CamionAuxilioService camionService = CamionAuxilioService.getInstancia();

		CamionAuxilio camion = null;

		if (!cliente.getTieneMora()) {
			camion = camionService.camionIndicadoParaPedido(vehiculo);
		}

		System.out.println(camion);
	}
}
