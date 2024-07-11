package dev.kropotov.accounts.repository;

import dev.kropotov.accounts.entity.AccountPool;
import dev.kropotov.accounts.entity.ProductRegisterType;
import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountPoolRepository extends JpaRepository<AccountPool, Long> {
    @Query(value = "select p from AccountPool p " +
            "where p.branch = ?1 " +
            "and p.currency = ?2 " +
            "and p.mdmCode = ?3 " +
            "and p.priorityCode = ?4 " +
            "and p.registryType = ?5")
    AccountPool findAccountPool(
            Branch branch, Currency currency, String mdmCode, String priorityCode, ProductRegisterType registryType);
}
