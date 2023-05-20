package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.math.SimpleCalculator;
import io.micrometer.common.util.StringUtils;

@RestController
public class MathController {
	
	private SimpleCalculator calc = new SimpleCalculator();

	@GetMapping(value="/sum/{numberOne}/{numberTwo}")
	public Double sum(
					@PathVariable(value = "numberOne") String numberOne,
					@PathVariable(value = "numberTwo") String numberTwo
			 	) throws Exception {

		return calc.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping(value="/sub/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value="numberOne") String num1, 
			                  @PathVariable(value="numberTwo") String num2) {

		return calc.subtraction(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@GetMapping(value="/mult/{multiplicando}/{multiplicador}")
	public Double multiplication(@PathVariable(value="multiplicando") String num1, 
			                     @PathVariable(value="multiplicador") String num2) {

		return calc.multiplication(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@GetMapping(value="/div/{dividendo}/{divisor}")
	public Double division(@PathVariable(value="dividendo") String num1,
			               @PathVariable(value="divisor") String num2) {

		return calc.division(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@GetMapping(value="/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value="numberOne") String num1,
			           @PathVariable(value="numberTwo") String num2) {

		return calc.mean(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@GetMapping(value="/pow/{base}/{expoente}")
	public Double power(@PathVariable(value="base") String num1,
						@PathVariable(value="expoente") String num2) {

		return calc.power(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	/*
	 * RADICIACAO /root/
	 * Realiza o cálculo da base (num1) pelo índice (num2).
	 * 
	 * EasterEgg:
	 * Se o num2 não for informado, será assumido como sendo 2. 
	 * Ou seja, sera calculada a raiz quadrada de num1.
	 * 
	 */
	@GetMapping(value={"/sqr/{radicando}", "/root/{radicando}", "/root/{radicando}/{indice}"})
	public Double root(@PathVariable(value="radicando") String num1,
			           @PathVariable(value="indice", required=false) String num2) {

		return calc.root(NumberConverter.convertToDouble(num1),
									 NumberConverter.convertToDouble(StringUtils.isEmpty(num2) ? "2" : num2));
	}

}
