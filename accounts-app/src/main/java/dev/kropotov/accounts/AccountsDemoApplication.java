package dev.kropotov.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("dev.kropotov.accounts.entity")
@ComponentScan("dev.kropotov.accounts.*")
@EnableJpaRepositories(basePackages = "dev.kropotov.accounts.repository")
@EnableTransactionManagement
public class AccountsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsDemoApplication.class, args);
    }

}
