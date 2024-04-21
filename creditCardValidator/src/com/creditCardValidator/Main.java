package com.creditCardValidator;

import com.creditCardValidator.CardException.*;

public class Main {
	public static void main(String[] args) {
		try {
			Card card = new Card(4652833662434486L, "0419", "081");
			boolean[] cardStatus = card.validateCard();

			for (boolean status : cardStatus) {
				System.out.println(status);
			}

		} catch (CardException e) {
			e.printStackTrace();
		}
	}
}