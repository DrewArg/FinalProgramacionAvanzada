package ar.edu.davinci.domain;

public class GranGrua extends CamionAuxilio {

	private Boolean tallerAsociado;

	public GranGrua(Ubicacion ubicacion) {
		super(ubicacion);
	}

	public GranGrua(Ubicacion ubicacion, Boolean tallerAsociado) {
		super(ubicacion);
		this.tallerAsociado = tallerAsociado;
	}

	public Boolean getTallerAsociado() {
		return tallerAsociado;
	}

	public void setTallerAsociado(Boolean tallerAsociado) {
		this.tallerAsociado = tallerAsociado;
	}

}
