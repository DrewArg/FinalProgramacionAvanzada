package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Classic;
import ar.edu.davinci.domain.clases.Economic;
import ar.edu.davinci.domain.clases.Membresia;
import ar.edu.davinci.domain.clases.Platinum;
import ar.edu.davinci.domain.enumerados.TipoMembresia;

public class MembresiaService {

	List<Membresia> membresias = new ArrayList<Membresia>();

	public String addMembresia(Membresia membresia) {

		membresias.add(membresia);

		return "Membresía agregada con exito.";
	}

	public Membresia factoryMembresia(TipoMembresia tipoMembresia) {

		Membresia membresia = null;

		if (tipoMembresia == TipoMembresia.PLATINUM) {

			membresia = new Platinum(tipoMembresia);

			membresia.setTopeRemolques(null);
			membresia.setTopeReparaciones(null);

			membresias.add(membresia);

		} else if (tipoMembresia == TipoMembresia.CLASSIC) {

			membresia = new Classic(tipoMembresia);

			membresia.setTopeRemolques(5);
			membresia.setTopeReparaciones(null);

			membresias.add(membresia);

		} else {

			membresia = new Economic(tipoMembresia);

			membresia.setTopeRemolques(0);
			membresia.setTopeReparaciones(5);

			membresias.add(membresia);
		}

		return membresia;
	}

}
