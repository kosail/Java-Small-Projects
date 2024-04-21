package com.creditCardValidator.CardException;

public class InvalidCardIssuerException extends CardException {
	public InvalidCardIssuerException() {
		super("Bank issuer is invalid or is not supported");
	}

	public InvalidCardIssuerException(String message) {
		super(message);
	}
}
