package dev.kropotov.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @ManyToOne
    private AccountPool accountPool;
}
