package br.com.erudio.converters;

import br.com.erudio.exceptions.InvalidNumberException;

public class NumberConverter {

	public static Double convertToDouble(String strNumber) throws InvalidNumberException {
		if(strNumber == null) return 0D;
		// BR 10,25 - US 10.25
		String number = strNumber.replaceAll(",", ".");

		Double result;

		try {

			result = Double.parseDouble(number);

		} catch (Exception ex) {

			throw new InvalidNumberException(String.format("O valor informado '%s' não é numérico.", strNumber));
		}

		return result;
	}

	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}


}
