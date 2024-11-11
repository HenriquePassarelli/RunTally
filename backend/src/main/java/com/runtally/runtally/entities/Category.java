package com.runtally.runtally.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(nullable = false)
    @NotEmpty(message = "Distance is required")
    private Long distance;

    @NotEmpty(message = "Min year is required")
    @Column(nullable = false, length = 4)
    @Size(min = 4, max = 4)
    private Integer minYear;

    @NotEmpty(message = "Max year is required")
    @Column(nullable = false, length = 4)
    @Size(min = 4, max = 4)
    private Integer maxYear;

    private String description;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Long createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Long lastModification;

    public Category() {
    }

    public Category(String name, Long distance, Integer minYear, Integer maxYear, String description) {
        this.name = name;
        this.distance = distance;
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Long getDistance() {
        return distance;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public String getDescription() {
        return description;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getLastModification() {
        return lastModification;
    }

}
