package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.CamionAuxilio;
import ar.edu.davinci.domain.clases.GranGrua;
import ar.edu.davinci.domain.clases.MiniGrua;
import ar.edu.davinci.domain.clases.MiniTallerMovil;
import ar.edu.davinci.domain.clases.Ubicacion;
import ar.edu.davinci.domain.clases.Vehiculo;
import ar.edu.davinci.domain.enumerados.TipoReparacion;

public class CamionAuxilioService {

	private static CamionAuxilioService instancia;
	private List<CamionAuxilio> auxilios = new ArrayList<CamionAuxilio>();

	private CamionAuxilioService() {

	}

	public synchronized static CamionAuxilioService getInstancia() {
		if (instancia == null) {
			instancia = new CamionAuxilioService();
		}

		return instancia;
	}

	public void addMiniTallerMovil(Double longitud, Double latitud, String patente) {
		MiniTallerMovil minitaller = new MiniTallerMovil(new Ubicacion(longitud, latitud), patente);

		auxilios.add(minitaller);

		System.out.println(minitaller);
	}

	public void addMiniGrua(Double longitud, Double latitud, String patente) {
		MiniGrua miniGrua = new MiniGrua(new Ubicacion(longitud, latitud), patente);

		auxilios.add(miniGrua);

		System.out.println(miniGrua);
	}

	public void addGranGrua(Double longitud, Double latitud, String patente) {
		GranGrua granGrua = new GranGrua(new Ubicacion(longitud, latitud), patente);

		auxilios.add(granGrua);

		System.out.println(granGrua);
	}

	public void addGranGruaConTaller(Double longitud, Double latitud, String patente) {
		GranGrua granGrua = new GranGrua(new Ubicacion(longitud, latitud), patente, true);

		auxilios.add(granGrua);

		System.out.println(granGrua);
	}

	public CamionAuxilio getCamionAuxilio(String patente) {

		CamionAuxilio camion = null;

		for (CamionAuxilio camionAuxilio : auxilios) {
			if (camionAuxilio.getPatente().equals(patente)) {
				camion = camionAuxilio;
			}
		}
		return camion;
	}

	public CamionAuxilio camionIndicadoParaPedido(Vehiculo vehiculo) {
		CamionAuxilio camionIndicado = null;

		List<CamionAuxilio> camiones = new ArrayList<CamionAuxilio>();

		for (CamionAuxilio camion : auxilios) {

			if (!vehiculo.getProblema().getRequiereRemolque()) {

				if (camion instanceof MiniTallerMovil) {

					System.out.println(camiones + " MiniTallerMovil");

					camiones.add(camion);

					camionIndicado = buscarCamionCercano(vehiculo.getUbicacion(), camiones);
				}

			} else if (vehiculo.getProblema().getRequiereRemolque()
					&& vehiculo.getProblema().getTipoReparacion() == TipoReparacion.REMOLQUE
					&& vehiculo.getToneladas() <= 3) {

				if (camion instanceof MiniGrua) {

					System.out.println(camiones + " MiniGrua");

					camiones.add(camion);

					camionIndicado = buscarCamionCercano(vehiculo.getUbicacion(), camiones);
				}

			} else if (vehiculo.getProblema().getRequiereRemolque()
					&& vehiculo.getProblema().getTipoReparacion() == TipoReparacion.REMOLQUE
					&& vehiculo.getToneladas() > 3) {

				if (camion instanceof GranGrua) {

					System.out.println(camiones + " GranGrua");

					camiones.add(camion);

					camionIndicado = buscarCamionCercano(vehiculo.getUbicacion(), camiones);
				}

			} else {

				if (camion instanceof GranGrua && ((GranGrua) camion).getTallerAsociado()) {

					System.out.println(camiones + " GranGrua con taller");

					camiones.add(camion);

					camionIndicado = buscarCamionCercano(vehiculo.getUbicacion(), camiones);
				}

			}
		}

		camionIndicado.addPedido(vehiculo);

		System.out.println(camionIndicado);
		return camionIndicado;
	}

	private CamionAuxilio buscarCamionCercano(Ubicacion ubicacionCliente, List<CamionAuxilio> camiones) {

		double distancia;
		double distanciaMenor = 0;
		CamionAuxilio camion = null;

		for (int i = 0; i < camiones.size(); i++) {

			distancia = Math.sqrt(
					Math.pow((camiones.get(i).getUbicacion().getLongitud() - ubicacionCliente.getLongitud()), 2) + Math
							.pow((camiones.get(i).getUbicacion().getLatitud() - ubicacionCliente.getLatitud()), 2));

			if (i == 0) {

				distanciaMenor = distancia;

				camion = camiones.get(0);

			} else {

				if (distancia < distanciaMenor) {

					distanciaMenor = distancia;

					camion = camiones.get(i);
				}
			}
		}
		System.out.println(camion);

		return camion;
	}

}
