package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Problema;
import ar.edu.davinci.domain.enumerados.TipoReparacion;

public class ProblemaService {

	List<Problema> problemas = new ArrayList<Problema>();

	public Problema addAndReturnProblema(String descripcion, TipoReparacion tipoReparacion) {

		Problema problema = new Problema(descripcion, tipoReparacion);

		problemas.add(problema);

		return problema;
	}

}
