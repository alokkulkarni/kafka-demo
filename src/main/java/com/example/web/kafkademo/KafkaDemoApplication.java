package com.example.web.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;


@RestController
@SpringBootApplication
public class KafkaDemoApplication {


	@GetMapping("/message")
	public ResponseEntity<MsgSchema> getMessage() {

		Random random = new Random();

		MsgSchema msgSchema = new MsgSchema();
		msgSchema.setId(UUID.randomUUID().toString());
		msgSchema.setVendorName("Apple");
		msgSchema.setLocation("London");
		msgSchema.setLocation("Covent Garden");
		msgSchema.setCurrency("GBP");
		msgSchema.setAmount(String.valueOf(random.nextInt(100)));
		msgSchema.setTransTime(ZonedDateTime.now().toLocalDateTime().toString());

		return new ResponseEntity<>(msgSchema, HttpStatus.OK);
	}




	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}
}
