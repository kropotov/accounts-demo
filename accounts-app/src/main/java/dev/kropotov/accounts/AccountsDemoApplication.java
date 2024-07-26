package dev.kropotov.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "dev.kropotov.accounts")
@EntityScan("dev.kropotov.accounts.entity")
@EnableTransactionManagement
public class AccountsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsDemoApplication.class, args);
    }

}
