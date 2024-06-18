package ar.edu.unlam.dominio;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Alicia implements Comprador {

	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dinero;
	private List<Alimento> alimentos;

	public Alicia(Double dinero) {
		this.altura = 180.0;
		this.peso = 50.0;
		this.nombre = "Alicia";
		this.edad = 15;
		this.dinero = dinero;
		this.alimentos = new ArrayList<>();
	}

	@Override
	public Boolean comprarAlimento(Alimento alimentoAComprar) throws DineroInsuficienteException {
		if (this.dinero >= alimentoAComprar.getPrecio()) {
			alimentos.add(alimentoAComprar);
			setDinero(getDinero() - alimentoAComprar.getPrecio());
			return true;
		} else {
			throw new DineroInsuficienteException("dinero insuficiente");
		}
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public Double getDinero() {
		return dinero;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public void consumirAlimento(Alimento alimentoAConsumir) throws AlturaLimiteException {
		if (alimentos.contains(alimentoAConsumir)) {

			if (alimentoAConsumir instanceof Agrandador) {
				if (this.altura + alimentoAConsumir.getTamañoAModificar() > 280) {
					throw new AlturaLimiteException("Tamaño limite");
				}
				setAltura(this.altura + alimentoAConsumir.getTamañoAModificar());
				alimentos.remove(alimentoAConsumir);
			}

			if (alimentoAConsumir instanceof Achicador) {
				if (this.altura - alimentoAConsumir.getTamañoAModificar() < 50) {
					throw new AlturaLimiteException("Tamaño limite");
				}
				setAltura(this.altura - alimentoAConsumir.getTamañoAModificar());
				alimentos.remove(alimentoAConsumir);
			}
		}
	}

	public List<Alimento> ordenarAlimentoDescendente() {
		Collections.sort(alimentos,new ComparadorDeAlimentos());
		return alimentos;
	}

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
	

}
