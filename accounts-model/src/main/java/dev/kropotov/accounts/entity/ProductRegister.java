package dev.kropotov.accounts.entity;

import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.enums.converter.CurrencyConverter;
import dev.kropotov.accounts.enums.State;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tpp_product_register")
public class ProductRegister implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "value")
    private ProductRegisterType type;

    @ManyToOne
    @JoinColumn(name = "account")
    private Account account;

    @Column(name = "currency_code")
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;

    @Enumerated
    private State state;

    @Column
    private String accountNumber;

}
