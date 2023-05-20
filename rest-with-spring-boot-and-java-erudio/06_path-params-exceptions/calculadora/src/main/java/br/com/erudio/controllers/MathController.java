package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleCalculator;
import io.micrometer.common.util.StringUtils;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
					@PathVariable(value = "numberOne") String numberOne,
					@PathVariable(value = "numberTwo") String numberTwo
			 	) throws Exception {

//  		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
// 			throw new UnsupportedMathOperationException("[Sum] Informe valores numericos.");
//		}
		return SimpleCalculator.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value="numberOne") String num1, 
			                  @PathVariable(value="numberTwo") String num2) throws UnsupportedMathOperationException {

		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {

			throw new UnsupportedMathOperationException("[Subtraction] Informe valores numericos.");
		}

		return SimpleCalculator.subtraction(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value="/mult/{multiplicando}/{multiplicador}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value="multiplicando") String num1, 
			                     @PathVariable(value="multiplicador") String num2) {

		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Multiplication] Informe valores numericos.");
		}
		
		return SimpleCalculator.multiplication(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value="/div/{dividendo}/{divisor}", method=RequestMethod.GET)
	public Double division(@PathVariable(value="dividendo") String num1,
			               @PathVariable(value="divisor") String num2) {

		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Division] Informe valores numericos.");
		}

		return SimpleCalculator.division(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable(value="numberOne") String num1,
			           @PathVariable(value="numberTwo") String num2) throws UnsupportedMathOperationException {

		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Mean] Informe valores numericos.");
		}
		return SimpleCalculator.mean(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));

	}

	@RequestMapping(value="/pow/{base}/{expoente}", method=RequestMethod.GET)
	public Double power(@PathVariable(value="base") String num1,
						@PathVariable(value="expoente") String num2) 
								throws UnsupportedMathOperationException {

		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("[Power] Informe valores numericos.");
		}

		return SimpleCalculator.power(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
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
		
		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(indice)) {
			throw new UnsupportedMathOperationException("[Root] Informe valores numericos.");
		}
		return SimpleCalculator.root(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(indice));
	}

}
