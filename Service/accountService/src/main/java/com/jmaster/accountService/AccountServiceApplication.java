package com.jmaster.accountService;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public NewTopic notification() {
        return new NewTopic("notification2", 2, (short) 2);
    }

    @Bean
    public NewTopic statictis() {
        return new NewTopic("statictis", 2, (short) 2);
    }

}
