package com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
