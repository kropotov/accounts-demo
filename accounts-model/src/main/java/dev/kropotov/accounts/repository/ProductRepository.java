package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p from Product p where p.number = ?1")
    List<Product> findProductByNumber(String number);
}
