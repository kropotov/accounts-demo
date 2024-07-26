package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.ProductClass;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductClassRepository extends JpaRepository<ProductClass, Long> {
    ProductClass findByValue(String value);
}
