package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
