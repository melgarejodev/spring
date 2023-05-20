package br.com.erudio.math;

public class SimpleCalculator {

	// Soma
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}

	// Subtracao
	public Double subtraction(Double num1, Double num2) {
		return num1 - num2; 
	}

	// Multiplicacao
	public Double multiplication(Double num1, Double num2) {
		return num1 * num2; 
	}

	// Divisao
	public Double division(Double num1, Double num2) {
		return num1 / num2;
	}

	// Media aritmetica
	public Double mean(Double num1, Double num2) {
		return this.sum(num1, num2) / 2;
	}

	// Potenciacao
	public Double power(Double num1, Double num2) {
		return Math.pow(num1, num2); 
	}
	
	// Raiz
	public Double root(Double num1, Double num2) {
		return Math.pow(num1, (1/num2)); 
	}
	
}
