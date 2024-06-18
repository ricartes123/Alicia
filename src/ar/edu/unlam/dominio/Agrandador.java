package ar.edu.unlam.dominio;

public class Agrandador extends Alimento {
	private TipoAgrandador tipo;
	public Agrandador(Double precio, TipoAgrandador tipo, String nombre) {
		super(50.0, precio, nombre);
		this.tipo = tipo;
	}

}
