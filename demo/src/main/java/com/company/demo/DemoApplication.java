package com.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@EnableConfigServer
@SpringBootApplication
public class DemoApplication {
	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/index")
	public String getIndex(){
		return "Spring Boot 8";
	}

	@GetMapping("/getController")
	public String getController(){
		return restTemplate.getForObject("http://localhost:8080/index",String.class);
	}

	@GetMapping("/getRest")
	public String getRest(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity(httpHeaders);
		return restTemplate.exchange("http://localhost:8080/index",
				HttpMethod.GET,httpEntity,String.class).getBody();



	}



}
