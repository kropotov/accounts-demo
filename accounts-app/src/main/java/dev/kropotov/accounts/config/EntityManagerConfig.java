package dev.kropotov.accounts.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan("dev.kropotov.accounts.entity")
@EnableJpaRepositories(basePackages = "dev.kropotov.accounts.repository")
@EnableTransactionManagement
public class EntityManagerConfig {
}
