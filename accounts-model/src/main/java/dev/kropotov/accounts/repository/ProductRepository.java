package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNumber(String number);
}
