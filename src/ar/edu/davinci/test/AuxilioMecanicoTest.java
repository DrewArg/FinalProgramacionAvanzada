package ar.edu.davinci.test;

import ar.edu.davinci.domain.enumerados.TipoMembresia;
import ar.edu.davinci.domain.enumerados.TipoReparacion;
import ar.edu.davinci.service.CamionAuxilioService;
import ar.edu.davinci.service.ClienteService;
import ar.edu.davinci.service.VehiculoService;

public class AuxilioMecanicoTest {

	public static void main(String[] args) {

		CamionAuxilioService camioneAuxilioService = CamionAuxilioService.getInstancia();
		ClienteService clienteService = ClienteService.getInstance();
		VehiculoService vehiculoService = VehiculoService.getInstance();

		camioneAuxilioService.addMiniTallerMovil(1.1, 1.1, "abc-123");
		camioneAuxilioService.addMiniGrua(1.1, 1.1, "abc-456");
		camioneAuxilioService.addGranGrua(1.1, 1.1, "abc-789");
		camioneAuxilioService.addGranGruaConTaller(1.1, 1.1, "789-abc");

		clienteService.addCliente("123", TipoMembresia.ECONOMMIC);
		clienteService.addCliente("456", TipoMembresia.CLASSIC);
		clienteService.addCliente("789", TipoMembresia.CLASSIC);
		clienteService.addCliente("654", TipoMembresia.CLASSIC);
		clienteService.addCliente("321", TipoMembresia.PLATINUM);

		vehiculoService.addVehiculo("abc", 3.0);
		vehiculoService.addVehiculo("def", 3.0);
		vehiculoService.addVehiculo("ghi", 3.2);
		vehiculoService.addVehiculo("jkl", 3.0);
		vehiculoService.addVehiculo("mno", 3.0);

		clienteService.asignarVehiculoCliente("123", vehiculoService.buscarVehiculoByPatente("abc"));
		clienteService.asignarVehiculoCliente("456", vehiculoService.buscarVehiculoByPatente("def"));
		clienteService.asignarVehiculoCliente("789", vehiculoService.buscarVehiculoByPatente("ghi"));
		clienteService.asignarVehiculoCliente("654", vehiculoService.buscarVehiculoByPatente("jkl"));
		clienteService.asignarVehiculoCliente("321", vehiculoService.buscarVehiculoByPatente("mno"));

		clienteService.reportarProblema("123", "abc", "Rompi", TipoReparacion.REPARACION_COMPLEJA, 5.0, 5.0);
		clienteService.reportarProblema("456", "def", "Rompi", TipoReparacion.REMOLQUE, 5.0, 5.0);
		clienteService.reportarProblema("789", "ghi", "Rompi", TipoReparacion.REMOLQUE, 5.0, 5.0);
		clienteService.reportarProblema("654", "jkl", "Rompi", TipoReparacion.REMOLQUE, 5.0, 5.0);
		clienteService.reportarProblema("321", "mno", "Rompi", TipoReparacion.REPARACION_COMPLEJA, 5.0, 5.0);
	}

}
