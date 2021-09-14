package com.cts.swd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringWebfluxWebmvcClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxWebmvcClientDemoApplication.class, args);
	}

	@Value("${books.api}")
	private String bookApi;
	
	@Bean
	public WebClient webClient() {
		return WebClient.create(bookApi);
	}
}
