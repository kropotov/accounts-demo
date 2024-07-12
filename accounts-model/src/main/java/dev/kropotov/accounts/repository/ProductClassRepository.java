package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.ProductClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductClassRepository extends JpaRepository<ProductClass, Long> {
    @Query(value = "select p from ProductClass p where p.value = ?1")
    ProductClass findProductClassByValue(String value);
}
