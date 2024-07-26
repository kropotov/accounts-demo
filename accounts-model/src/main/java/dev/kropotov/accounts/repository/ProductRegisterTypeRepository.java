package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.ProductRegisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRegisterTypeRepository extends JpaRepository<ProductRegisterType, Long> {
    ProductRegisterType findByValue(String value);

    @Query(value = "select r from ProductRegisterType r where r.productClass.value = ?1")
    List<ProductRegisterType> findByProductClassValue(String value);
}
