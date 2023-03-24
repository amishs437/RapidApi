package com.example.rapid.api;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RapidApiApplication {

	public static void main(String[] args) throws UnirestException {
		SpringApplication.run(RapidApiApplication.class, args);

	}

}
