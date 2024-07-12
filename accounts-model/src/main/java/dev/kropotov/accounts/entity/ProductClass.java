package dev.kropotov.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tpp_ref_product_class")
public class ProductClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id")
    private Long id;

    @Column
    String value;
}
