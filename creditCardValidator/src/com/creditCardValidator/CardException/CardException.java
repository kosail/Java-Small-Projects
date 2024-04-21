package com.creditCardValidator.CardException;

public class CardException extends Exception {
	public CardException() {
		super();
	}

	public CardException(String message) {
		super(message);
	}

	public CardException(String message, Throwable e) {
		super(message, e);
	}
}
