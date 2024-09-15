package org.jointheleague.dogsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogsearchApplication.class, args);
	}
//Use 'http://localhost:5000/searchLocResults?q=2' to search
}
