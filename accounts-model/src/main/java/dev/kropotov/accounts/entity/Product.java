package dev.kropotov.accounts.entity;

import dev.kropotov.accounts.enums.State;
import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductRegister> registers;

    //TODO: все остальные поля продукта

}
