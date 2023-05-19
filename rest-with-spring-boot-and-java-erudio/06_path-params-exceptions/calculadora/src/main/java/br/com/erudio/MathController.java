package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import io.micrometer.common.util.StringUtils;

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

	@RequestMapping(value="/mult/{multiplicando}/{multiplicador}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value="multiplicando") String num1, 
			                     @PathVariable(value="multiplicador") String num2) {

		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Multiplication] Informe valores numericos.");
		}
		
		return convertToDouble(num1) * convertToDouble(num2); 
	}

	@RequestMapping(value="/div/{dividendo}/{divisor}", method=RequestMethod.GET)
	public Double division(@PathVariable(value="dividendo") String num1,
			               @PathVariable(value="divisor") String num2) {

		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Division] Informe valores numericos.");
		}

		return convertToDouble(num1) / convertToDouble(num2);
	}

	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double average(@PathVariable(value="numberOne") String num1,
			              @PathVariable(value="numberTwo") String num2) throws UnsupportedMathOperationException {

		final Double result;
		
		try {

			result = this.sum(num1, num2) / 2;

		} catch (Exception e) {
			throw new UnsupportedMathOperationException("[Average] Informe valores numericos.");
		}
		return result;
	}

	@RequestMapping(value="/pow/{base}/{expoente}", method=RequestMethod.GET)
	public Double power(@PathVariable(value="base") String num1,
						@PathVariable(value="expoente") String num2) 
								throws UnsupportedMathOperationException {

		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Power] Informe valores numericos.");
		}

		return Math.pow(convertToDouble(num1), convertToDouble(num2)); 
	}
	
	/*
	 * RADICIACAO /pow/
	 * Realiza o cálculo da base (num1) pelo índice (num2).
	 * Se o num2 não for informado, será assumido como sendo 2, ou seja, sera calculada a raiz quadrada de num1.
	 * 
	 */
	@RequestMapping(value={"/sqr/{radicando}", "/root/{radicando}","/root/{radicando}/{indice}"}, method=RequestMethod.GET)
	public Double root(@PathVariable(value="radicando") String num1,
			           @PathVariable(value="indice", required=false) String num2) 
			        		   throws UnsupportedMathOperationException {
		
		final String indice = StringUtils.isEmpty(num2) ? "2" : num2; 
		
		if(!isNumeric(num1) || !isNumeric(indice)) {
			throw new UnsupportedMathOperationException("[Root] Informe valores numericos.");
		}
		return Math.pow(convertToDouble(num1), (1/convertToDouble(indice))); 

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
