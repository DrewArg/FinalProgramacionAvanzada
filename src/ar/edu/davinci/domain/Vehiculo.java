package ar.edu.davinci.domain;

public class Vehiculo {

	private Ubicacion ubicacion; // longitud (x) y latitud (y)
	private Problema problema;
	private Double toneladas;
	private String patente;

	public Vehiculo(String patente, Double toneladas) {
		this.patente = patente;
		this.toneladas = toneladas;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Problema getProblema() {
		return problema;
	}

	public Double getToneladas() {
		return toneladas;
	}

	public String getPatente() {
		return patente;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}
}
