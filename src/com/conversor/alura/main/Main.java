package com.conversor.alura.main;

import java.util.Scanner;
import java.util.Map;

import com.conversor.alura.main.conection.Conection;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {

	public static void main(String[] args) {
	    Scanner entrada = new Scanner(System.in);
	    Gson gson = new Gson();

	    // JSON con los tipos de cambio
	    Conection conection = new Conection();
	    String jsonData = conection.fetchData();

	    JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
	    JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
	    double pesoColombiano = conversionRates.get("COP").getAsDouble();
	    double pesoArgentino = conversionRates.get("ARS").getAsDouble();
	    double realBrasil = conversionRates.get("BRL").getAsDouble();

	    double saldo;
	    String teclado;
	    boolean bandera = true;

	    // Menú
	    System.out.println("*******************************************************");
	    System.out.println("Bienvenido/a al Conversor de Moneda =]");
	    System.out.println("");
	    System.out.println("1) Dolar =>> Peso Argentino");
	    System.out.println("2) Peso Argentino =>> Dolar");
	    System.out.println("3) Dolar => Real Brasileño");
	    System.out.println("4) Real Brasileño =>> Dolar");
	    System.out.println("5) Dolar => Peso Colombiano");
	    System.out.println("6) Peso Colombiano =>> Dolar");
	    System.out.println("7) Salir");
	    System.out.println("");
	    System.out.println("*******************************************************");
	    System.out.println("Elija una opción válida:");
	    
	    
	    while (bandera) {
	        
	        int opcion = entrada.nextInt();

	        switch (opcion) {
	            case 1:
	                System.out.println("Ingrese la cantidad en Dólares:");
	                teclado = entrada.next().replace(',', '.');
	                saldo = Double.parseDouble(teclado);
	                System.out.println(saldo + " Dólares equivale a " + (saldo * pesoArgentino) + " Pesos Argentinos.");
	                break;
	            case 2:
	                System.out.println("Ingrese la cantidad en Pesos Argentinos:");
	                teclado = entrada.next().replace(',', '.');
	                saldo = Double.parseDouble(teclado);
	                System.out.println(saldo + " Pesos Argentinos equivale a " + (saldo / pesoArgentino) + " Dólares.");
	                break;
	            case 3:
	                System.out.println("Ingrese la cantidad en Dólares:");
	                teclado = entrada.next().replace(',', '.');
	                saldo = Double.parseDouble(teclado);
	                System.out.println(saldo + " Dólares equivale a " + (saldo * realBrasil) + " Real Brasileño.");
	                break;
	            case 4:
	                System.out.println("Ingrese la cantidad de Reales Brasileños:");
	                teclado = entrada.next().replace(',', '.');
	                saldo = Double.parseDouble(teclado);
	                System.out.println(saldo + " Reales Brasileños equivale a " + (saldo / realBrasil) + " Dólares.");
	                break;
	            case 5:
	                System.out.println("Ingrese la cantidad en Dólares:");
	                teclado = entrada.next().replace(',', '.');
	                saldo = Double.parseDouble(teclado);
	                System.out.println(saldo + " Dólares equivale a " + (saldo * pesoColombiano) + " Peso Colombiano.");
	                break;
	            case 6:
	                System.out.println("Ingrese la cantidad de Pesos Colombianos:");
	                teclado = entrada.next().replace(',', '.');
	                saldo = Double.parseDouble(teclado);
	                System.out.println(saldo + " Pesos Colombianos equivale a " + (saldo / pesoColombiano) + " Dólares.");
	                break;
	            case 7:
	                System.out.println("¡Hasta luego!");
	                bandera = false;
	                break;
	            default:
	                System.out.println("Opción no válida.");
	        }
	        System.out.println("¿ Desea seguir cambiando ?. S/N");
	        teclado = entrada.next();
	        if (teclado.equals(teclado)) {
	        	System.out.println("¡Hasta luego!");
                bandera = false;
			}
	        
	    }
	}
}