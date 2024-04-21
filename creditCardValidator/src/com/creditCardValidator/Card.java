package com.creditCardValidator;

import com.creditCardValidator.CardException.*;
import java.util.Calendar;

public class Card  {
	private final int[] cardNumber;
	private final int[] expDate;
	private final String cvv;

	public Card(long cardNumber, String expDate, String cvv) throws CardException {
		this.cardNumber = cardToArray(cardNumber); // Convert the cardNumber to an array of int, which will make things WAY easier.

		int firstDigit = this.cardNumber[0]; // Get the 1st digit of the card to check if it's AMEX/VISA/MC, as this program only support those 3 card issuers.
		int numberOfCardDigits = this.cardNumber.length; // Get the amount of digits of the registered card. AMEX cards = 15 digits, while VISA & MC = 16 digits
				
		if ( firstDigit < 3 || firstDigit > 5) {
			throw new InvalidCardIssuerException();
		}
		
		if (firstDigit == 3) {
			if (numberOfCardDigits != 15) {
				throw new InvalidCardNumberException("Invalid Card: American Express should have 15 digits.");
			}

			if (cvv.length() != 4) {
				throw new InvalidCVVException("Invalid CVV. American Express cards CVV's should have 4 digits");
			}
		}
		
		if (firstDigit == 4 || firstDigit == 5) {
			if (numberOfCardDigits != 16) {
				throw new InvalidCardNumberException("Invalid Card: VISA and MasterCard should have 16 digits.");
			}

			if (cvv.length() != 3) {
				throw new InvalidCVVException("Invalid CVV: MasterCard and VISA cards CVV's should have 3 digits.");
			}
		}

		if (expDate.length() != 4) {
			throw new InvalidExpirationDateException("Invalid Format: The expiration date should have the format MMYY");
		}

		this.expDate = expDateToArray(expDate);
		this.cvv = cvv; // Keep the CVV as string as it may contain a leading 0, which absense may break the transactions. It can theorically be stored in an array or in char, but as there is no way in which I can "verify" if the CVV is correct for the actual card, there is no point in implementing some feature that converts the cvv to an array or any other way to store it aside from a simple String.
	}

	private int[] cardToArray(long cardNumber) {
		int[] cardNumberArray = new int[(int) Math.floor(Math.log10(cardNumber)) + 1];
		char[] cardCharArray = Long.toString(cardNumber).toCharArray();

		for (int i=0; i<cardNumberArray.length; i++) {
			cardNumberArray[i] = cardCharArray[i] - '0';
		}

		return cardNumberArray;
	}

	private int[] expDateToArray(String expDate) {
		int[] expirationDateArray = new int[2];
		
		if (expDate.substring(0).equals("0")) {
			expirationDateArray[0] = Integer.parseInt(expDate.substring(1, 1));
		} else {
			expirationDateArray[0] = Integer.parseInt(expDate.substring(0, 2));
		}
		
		expirationDateArray[1] = Integer.parseInt(expDate.substring(2, 4));

		return expirationDateArray;
	}

	public boolean[] validateCard() {
		boolean[] cardStatus = new boolean[2];
		cardStatus[0] = validateCardNumber();

		try {
			boolean temp;

			if (temp = validateExpirationDate()) {
				cardStatus[1] = temp;
			}

		} catch (InvalidExpirationDateException e) {
			cardStatus[1] = false;
		}

		return cardStatus;
	}

	private boolean validateCardNumber() {
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

	private boolean validateExpirationDate() throws InvalidExpirationDateException {
		final Calendar timedateNow = Calendar.getInstance();
		final int month = timedateNow.get(Calendar.MONTH);
		final int year = timedateNow.get(Calendar.YEAR) % 100;

		if ((expDate[0] > 12 || expDate[1] > year) || expDate[1] == year && expDate[0] > month) {
			throw new InvalidExpirationDateException("The expiration date is not valid.");
		}

		return true;
	}
}