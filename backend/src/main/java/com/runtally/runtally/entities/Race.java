package com.runtally.runtally.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "RACE")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(nullable = false)
    @NotEmpty(message = "Location is required")
    private String location;

    @Column(nullable = false)
    @NotEmpty(message = "Date is required")
    private Long date;

    @Column(nullable = false)
    @NotEmpty(message = "Max athletes is required")
    private Long maxAthletes;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "RACE_ATHLETES",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    )
    @NotEmpty(message = "Athletes cannot be empty")
    @JsonIgnoreProperties({"athletes"})
    private List<Athlete> athletes;

    @OneToMany
    @JoinTable(
            name = "RACE_CATEGORIES",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    @NotEmpty(message = "Categories cannot be empty")
    @JsonIgnoreProperties({"categories"})
    private List<Category> categories;

    @OneToMany
    @JoinTable(
            name = "RACE_CONFIRMED_ATHLETES",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "confirmation_id", referencedColumnName = "id"))
    @JsonIgnoreProperties({"confirmedAthletes"})
    private List<Confirmation> confirmedAthletes;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Long createdAt;

    @Column(nullable = false)
    private Long lastModification;

    @PrePersist
    @PreUpdate
    private void prePersistOrUpdate() {
        if (this.athletes == null) {
            this.athletes = new ArrayList<>();
        }

        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }

        if (this.description == null) {
            this.description = "";
        }
    }
}
