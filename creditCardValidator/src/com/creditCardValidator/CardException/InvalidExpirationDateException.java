package com.creditCardValidator.CardException;

public class InvalidExpirationDateException extends CardException {
	public InvalidExpirationDateException() {
		super();
	}

	public InvalidExpirationDateException(String message) {
		super(message);
	}
}
