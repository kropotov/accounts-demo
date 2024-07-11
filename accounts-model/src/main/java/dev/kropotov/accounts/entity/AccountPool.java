package dev.kropotov.accounts.entity;

import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.converter.BranchConverter;
import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.enums.converter.CurrencyConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registry_type_code", referencedColumnName = "value")
    private ProductRegisterType registryType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_pool_id")
    private List<Account> accounts;
}
