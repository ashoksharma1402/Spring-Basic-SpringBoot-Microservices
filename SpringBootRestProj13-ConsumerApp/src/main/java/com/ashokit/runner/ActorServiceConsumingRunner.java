package com.ashokit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class object
		RestTemplate template=new RestTemplate();
		//define service url
		String serviceUrl="http://localhost:8080/actor/wish";
		//Generate Http request with get mode to consume the web service(API)
		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class);
		//Display the received details from the response
		System.out.println("Response body(output)       :: "+response.getBody());
		System.out.println("Response status code value  :: "+response.getStatusCodeValue());
		System.out.println("Response status code        :: "+response.getStatusCode().name());
		
		//system.exit(0);//optional

	}

}
