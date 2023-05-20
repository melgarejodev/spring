package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNumberException extends RuntimeException {

	public InvalidNumberException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
