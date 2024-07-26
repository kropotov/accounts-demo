package dev.kropotov.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.kropotov.accounts.*")
public class AccountsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsDemoApplication.class, args);
    }

}
