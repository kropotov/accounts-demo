package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.AccountPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountPoolRepository extends JpaRepository<AccountPool, Long> {
    @Query(value = "select p from AccountPool p where p.mdmCode = ?1")
    AccountPool findAccountPoolByMdmCode(String mdmCode);
}
