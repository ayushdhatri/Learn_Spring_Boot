package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {
	public static void main(String[] args) {
		// configure dotenv to load the env variables from .env file
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load(); // you can also pass the path to the .env file
		dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(DemoApplication.class, args);
	}
}





















