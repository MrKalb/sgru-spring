package br.com.ifrs.SGRU.exceptions;

public class EntityNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Exception ex){
		super(ex);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}
}

