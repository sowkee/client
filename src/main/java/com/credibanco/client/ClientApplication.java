package com.credibanco.client;

import com.credibanco.client.Consumir.HttpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClientApplication.class, args);
		HttpService.consumirService();
	}

}
