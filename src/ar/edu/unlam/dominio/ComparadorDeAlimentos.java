package ar.edu.unlam.dominio;

import java.util.Comparator;

public class ComparadorDeAlimentos implements Comparator <Alimento> {

	@Override
	public int compare(Alimento o1, Alimento o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
