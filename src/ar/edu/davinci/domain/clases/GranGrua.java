package ar.edu.davinci.domain.clases;

public class GranGrua extends CamionAuxilio {

	private Boolean tallerAsociado;

	public GranGrua(Ubicacion ubicacion, String patente) {
		super(ubicacion, patente);
		this.tallerAsociado = false;
	}

	public GranGrua(Ubicacion ubicacion, String patente, Boolean tallerAsociado) {
		super(ubicacion, patente);
		this.tallerAsociado = tallerAsociado;
	}

	public Boolean getTallerAsociado() {
		return tallerAsociado;
	}

	public void setTallerAsociado(Boolean tallerAsociado) {
		this.tallerAsociado = tallerAsociado;
	}

}
