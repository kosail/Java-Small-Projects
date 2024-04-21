package com.creditCardValidator.CardException;

public class InvalidCVVException extends CardException {
	public InvalidCVVException() {
		super("The registered CVV is not valid.");
	}

	public InvalidCVVException(String message) {
		super(message);
	}
}
