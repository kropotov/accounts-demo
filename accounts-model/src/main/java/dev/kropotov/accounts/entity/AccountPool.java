package dev.kropotov.accounts.entity;

import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.BranchConverter;
import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.enums.CurrencyConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class AccountPool implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_code")
    @Convert(converter = BranchConverter.class)
    private Branch branch;

    @Column(name = "currency_code")
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;

    @Column(unique = true)
    private String mdmCode;

    @Column
    private String priorityCode;

    @Column
    private String registryTypeCode;    //TODO: tpp_ref_product_register_type

    @OneToMany
    private Set<Account> accounts;
}
