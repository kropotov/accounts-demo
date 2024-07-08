package dev.kropotov.accounts.entity;

import dev.kropotov.accounts.enums.Currency;
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

    @Column
    private String type; //TODO: tpp_ref_product_register_type

    @ManyToOne
    private Account account;

    @Column
    private Currency currencyCode;

    @Enumerated
    private State state;

    @Column
    private String accountNumber;

}
