package dev.kropotov.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tpp_ref_product_register_type")
public class ProductRegisterType implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_class_code", referencedColumnName = "value")
    private ProductClass productClass;

}
