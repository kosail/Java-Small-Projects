package com.creditCardValidator;

import com.creditCardValidator.CardException.*;

public class Main {
	public static void main(String[] args) {
		try {
			Card card = new Card(4652833662434486L, "0420", "081");
			boolean[] cardStatus = card.validateCard();

			if (! cardStatus[0]) {
				System.err.println("La tarjeta es invalida");
			} else if (! cardStatus[1]) {
				System.err.println("La fecha de vencimiento es inválida.");
			} else {
				System.out.println("La tarjeta es válida.");
			}

		} catch (CardException e) {
			e.printStackTrace();
		}
	}
}