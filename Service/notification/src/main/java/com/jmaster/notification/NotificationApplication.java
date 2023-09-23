package com.jmaster.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;
<<<<<<< HEAD
import org.springframework.scheduling.annotation.EnableAsync;
=======
>>>>>>> 424193b6be9b87a501166d4767d39f7c686a5390

@SpringBootApplication
@EnableAsync
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Bean
	JsonMessageConverter converter(){
		return new JsonMessageConverter();
	}
}
