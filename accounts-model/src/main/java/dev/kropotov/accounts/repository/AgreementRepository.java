package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
