package ar.edu.davinci.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.domain.clases.Classic;
import ar.edu.davinci.domain.clases.Economic;
import ar.edu.davinci.domain.clases.Membresia;
import ar.edu.davinci.domain.clases.Platinum;
import ar.edu.davinci.domain.enumerados.TipoMembresia;

public class MembresiaService {

	private static MembresiaService instance;
	List<Membresia> membresias = new ArrayList<Membresia>();

	private MembresiaService() {
		
	}
	
	public synchronized static MembresiaService getInstance() {
		if(instance == null) {
			instance = new MembresiaService();
		}
		
		return instance;
	}
	
	public Membresia addMembresia(TipoMembresia tipoMembresia) {

		Membresia membresia = factoryMembresia(tipoMembresia);
		
		membresias.add(membresia);

		return membresia;
	}

	private Membresia factoryMembresia(TipoMembresia tipoMembresia) {

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
