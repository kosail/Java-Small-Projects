package com.creditCardValidator;

import com.creditCardValidator.CardException.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Ingresa el número de tarjeta (sin espacios ni guiones):\nEjemplo: 4444333322221111\n>> ");
			long creditCardNumber = Long.parseLong(br.readLine());
			System.out.print("Ingresa la fecha de vencimiento (MMYY):\nEjemplo: 0522\n>> ");
			String expirationDate = br.readLine();
			System.out.print("Ingresa el CVV: ");
			String cvv = br.readLine();

			Card card = new Card(creditCardNumber, expirationDate, cvv);
			boolean[] cardStatus = card.validateCard();

			if (! cardStatus[0]) {
				System.err.println("La tarjeta es invalida");
			} else if (! cardStatus[1]) {
				System.err.println("La fecha de vencimiento es inválida.");
			} else {
				System.out.println("La tarjeta es válida.");
			}

		} catch (IOException | CardException e) {
			System.err.println();
			e.printStackTrace();
		}
	}
}