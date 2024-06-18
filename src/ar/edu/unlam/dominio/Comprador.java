package ar.edu.unlam.dominio;

public interface Comprador {

	Boolean comprarAlimento(Alimento alimentoAgrandador) throws DineroInsuficienteException;
}
