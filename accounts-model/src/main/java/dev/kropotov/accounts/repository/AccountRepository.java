package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select a from Account a where a.accountNumber = ?1")
    List<Account> findAccountByAccountNumber(String accountNumber);
}
