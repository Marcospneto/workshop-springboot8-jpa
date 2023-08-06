package br.com.educandoweb.curso.model.servicos.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super(" Resource not found. Id " + id);
	}

}
