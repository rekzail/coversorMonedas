package com.conversor.alura.main.conection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Conection {
	
	
	private String json;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/a65b54d1d6f1f3c4f5cddef3/latest/USD")).build();

    HttpResponse<String> response;
    
    public String fetchData() {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
             json = response.body();
        
            

           
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		
        return (json);
        
}
}
