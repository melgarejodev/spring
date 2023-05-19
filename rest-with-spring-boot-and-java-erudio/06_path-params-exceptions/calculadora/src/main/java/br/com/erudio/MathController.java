package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
					@PathVariable(value = "numberOne") String numberOne,
					@PathVariable(value = "numberTwo") String numberTwo
			 	) throws Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {

			throw new UnsupportedMathOperationException("[Sum] Informe valores numericos.");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value="numberOne") String num1, 
			                  @PathVariable(value="numberTwo") String num2) throws UnsupportedMathOperationException {

		if(!isNumeric(num1) || !isNumeric(num2)) {

			throw new UnsupportedMathOperationException("[Subtraction] Informe valores numericos.");
		}

		return convertToDouble(num1) - convertToDouble(num2); 
	}

	@RequestMapping(value="/mult/{multiplicando}/{multiplicador}")
	public Double multiplication(@PathVariable(value="multiplicando") String num1, 
			                     @PathVariable(value="multiplicador") String num2) {

		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Multiplication] Informe valores numericos.");
		}
		
		return convertToDouble(num1) * convertToDouble(num2); 
	}

	@RequestMapping(value="/div/{dividendo}/{divisor}")
	public Double division(@PathVariable(value="dividendo") String num1,
			               @PathVariable(value="divisor") String num2) {

		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Division] Informe valores numericos.");
		}

		return convertToDouble(num1) / convertToDouble(num2);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		// BR 10,25
		// US 10.25
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);

		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
