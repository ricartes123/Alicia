package ar.edu.unlam.dominio;

public class Achicador extends Alimento {
	private TipoAchicador tipo;
	public Achicador(Double precio, TipoAchicador tipo, String nombre) {
		super(40.0, precio, nombre);
		this.tipo = tipo;
	}

}
