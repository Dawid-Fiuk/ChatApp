package com.chatApp.ChatApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.chatApp.ChatApp.model")
public class ChatAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChatAppApplication.class, args);
	}

}
