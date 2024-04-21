package com.creditCardValidator;

import com.creditCardValidator.CardException.*;

public class Main {
	public static void main(String[] args) {
		try {
			Card card = new Card(4652833662434486L);
			System.out.println(card.validateCard());;

		} catch (CardException e) {
			e.printStackTrace();
		}
	}
}