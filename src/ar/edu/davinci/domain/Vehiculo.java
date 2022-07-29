package ar.edu.davinci.domain;

public class Vehiculo {

	private Ubicacion ubicacion;
	private Double toneladas;
	private Problema problema;

	public Vehiculo(Ubicacion ubicacion, Double toneladas) {
		this.ubicacion = ubicacion;
		this.toneladas = toneladas;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Double getToneladas() {
		return toneladas;
	}

	public void setToneladas(Double toneladas) {
		this.toneladas = toneladas;
	}

	public Problema getProblema() {
		return problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}
}
