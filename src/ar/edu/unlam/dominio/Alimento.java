package ar.edu.unlam.dominio;

public class Alimento {
	private Double tamañoAModificar;
	private Double precio;
	private String nombre;
	
	public Alimento(Double tamañoAModificar, Double precio, String nombre) {
		this.tamañoAModificar = tamañoAModificar;
		this.precio = precio;
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getTamañoAModificar() {
		return tamañoAModificar;
	}

	public void setTamañoAModificar(Double tamañoAModificar) {
		this.tamañoAModificar = tamañoAModificar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
