package com.tamirnoach.springbootapp;

import com.tamirnoach.springbootapp.resources.LightRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		LightRestClient restClient = new LightRestClient();
		restClient.getAllLight();
	}

}
