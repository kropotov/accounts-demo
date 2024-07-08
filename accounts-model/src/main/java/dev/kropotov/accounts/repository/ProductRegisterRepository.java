package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.ProductRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRegisterRepository extends JpaRepository<ProductRegister, Long> {
}
