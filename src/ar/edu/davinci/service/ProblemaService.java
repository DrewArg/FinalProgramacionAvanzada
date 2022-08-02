package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Problema;
import ar.edu.davinci.domain.enumerados.TipoReparacion;

public class ProblemaService {

	List<Problema> problemas = new ArrayList<Problema>();

	public Problema addAndReturnProblema(String descripcion, TipoReparacion tipoReparacion) {

		Problema problema = factoryProblema(descripcion, tipoReparacion);

		problemas.add(problema);

		return problema;
	}

	private Problema factoryProblema(String descripcion, TipoReparacion tipoReparacion) {
		Problema resultado = null;

		if (tipoReparacion == TipoReparacion.REPARACION_COMPLEJA || tipoReparacion == TipoReparacion.REMOLQUE) {

			resultado = new Problema(descripcion, tipoReparacion);

			resultado.setRequiereRemolque(true);
		} else {
			
			resultado = new Problema(descripcion, tipoReparacion);

			resultado.setRequiereRemolque(false);
		}

		return resultado;
	}

}
