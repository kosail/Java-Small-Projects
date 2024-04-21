package com.creditCardValidator;

import com.creditCardValidator.CardException.*;

public class Card  {
	private final int[] cardNumber;

	public Card(long cardNumber) throws InvalidCardIssuerException, InvalidCardNumberException {
		this.cardNumber = cardToArray(cardNumber); // Convert the cardNumber to an array of int, which will make things WAY easier.

		int firstDigit = this.cardNumber[0]; // Get the first digit of the card to validate if it's AMEX, VISA or MC, as this program should only support those 3 card issuers.
				
		if ( firstDigit < 3 || firstDigit > 5) {
			throw new InvalidCardIssuerException();
		}

		int numberOfDigits = this.cardNumber.length; // Get the amount of digits of the registered card. AMEX cards = 15 digits, while VISA & MC = 16 digits
		
		if (firstDigit == 3 && numberOfDigits != 15) {
			throw new InvalidCardNumberException("Invalid Card: American Express should have 15 digits.");
		}

		if ((firstDigit == 4 || firstDigit == 5) && numberOfDigits != 16) {
			throw new InvalidCardNumberException("Invalid Card: VISA and MasterCard should have 16 digits.");
		}
	}

	private int[] cardToArray(long cardNumber) {
		int[] cardNumberArray = new int[(int) Math.floor(Math.log10(cardNumber)) + 1];
		char[] cardCharArray = Long.toString(cardNumber).toCharArray();

		for (int i=0; i<cardNumberArray.length; i++) {
			cardNumberArray[i] = cardCharArray[i] - '0';
		}

		return cardNumberArray;
	}

	public boolean validateCard() {
		int evenDoubledDigitsSum = 0, oddNumberedDigitsSum = 0;

		for (int i=cardNumber.length - 2; i>=0; i-=2) {
			if (cardNumber[i] > 0) {
				int doubledActualNumber = cardNumber[i] * 2;
				int numberOfDigits = (int) Math.floor(Math.log10(doubledActualNumber)) + 1;
	
				if (numberOfDigits != 1) {
					doubledActualNumber = (doubledActualNumber%10) + (doubledActualNumber/10);
				}
				evenDoubledDigitsSum += doubledActualNumber;
			}
		}

		for (int i=cardNumber.length - 1; i>=0; i-=2) {
			oddNumberedDigitsSum += cardNumber[i];
		}

		if ((evenDoubledDigitsSum + oddNumberedDigitsSum) % 10 == 0) {
			return true;
		}
		
		return false;
	}
}