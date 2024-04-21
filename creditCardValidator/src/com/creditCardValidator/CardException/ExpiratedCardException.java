package com.creditCardValidator.CardException;

public class ExpiratedCardException extends CardException {
	public ExpiratedCardException() {
		super("The card has already expired");
	}
}
