package com.runtally.runtally.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnoreProperties({"permissions", "users"})
    private Collection<Role> roles;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Long createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Long lastModification;

    public Permission() {
    }

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @PrePersist
    @PreUpdate
    private void prePersistOrUpdate() {
        if (this.description == null) {
            this.description = "";
        }

        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getLastModification() {
        return lastModification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
