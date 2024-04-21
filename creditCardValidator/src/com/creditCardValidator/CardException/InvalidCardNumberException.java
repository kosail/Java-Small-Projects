package com.creditCardValidator.CardException;

public class InvalidCardNumberException extends CardException {
	public InvalidCardNumberException() {
		super("The registered card is not valid");
	}

	public InvalidCardNumberException(String message) {
		super(message);
	}

	public InvalidCardNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
