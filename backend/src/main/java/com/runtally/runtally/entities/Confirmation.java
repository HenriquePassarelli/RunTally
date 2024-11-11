package com.runtally.runtally.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "CONFIRMATION")
public class Confirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Code is required")
    private String code;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Long createdAt;

    @ManyToOne
    @JoinColumn(name = "race_id", insertable = false, updatable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "athlete_id", insertable = false, updatable = false)
    private Athlete athlete;
}
