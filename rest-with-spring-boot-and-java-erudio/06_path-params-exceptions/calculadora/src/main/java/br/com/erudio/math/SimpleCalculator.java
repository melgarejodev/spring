package br.com.erudio.math;

public class SimpleCalculator {

	// Soma
	public static Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}

	// Subtracao
	public static Double subtraction(Double num1, Double num2) {
		return num1 - num2; 
	}

	// Multiplicacao
	public static Double multiplication(Double num1, Double num2) {
		return num1 * num2; 
	}

	// Divisao
	public static Double division(Double num1, Double num2) {
		return num1 / num2;
	}

	// Media aritmetica
	public static Double mean(Double num1, Double num2) {
		return SimpleCalculator.sum(num1, num2) / 2;
	}

	// Potenciacao
	public static Double power(Double num1, Double num2) {
		return Math.pow(num1, num2); 
	}
	
	// Raiz
	public static Double root(Double num1, Double num2) {
		return Math.pow(num1, (1/num2)); 
	}
	
}
