package dev.kropotov.accounts.entity;

import dev.kropotov.accounts.enums.State;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "tpp_product")
public class Product implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private State state;

    @Column
    private String number;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductRegister> registers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Agreement> agreements;

    @Column
    private String type; //TODO: enum

    @Column(name = "product_code_id")
    private Long productCode;

    @Column
    private Long priority;

    @Column
    private LocalDate dateOfConclusion;

    //TODO: все остальные поля продукта

}
