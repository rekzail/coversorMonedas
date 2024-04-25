/**
 * 
 */
/**
 * 
 */
module ConversorMoneda {
	requires java.net.http;
	requires com.google.gson;
	exports com.conversor.alura.main;
	exports com.conversor.alura.main.conection;
	opens com.conversor.alura.main to com.google.gson;
	
	
}