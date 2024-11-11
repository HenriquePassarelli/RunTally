package com.runtally.runtally.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name is required")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties({"roles"})
    private Collection<User> users;

    @ManyToMany
    @JoinTable(name = "ROLES_PERMISSIONS",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permissions_id", referencedColumnName = "id")
    )
    @NotEmpty(message = "Permissions are required")
    @JsonIgnoreProperties({"roles"})
    private Collection<Permission> permissions;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Long createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Long lastModification;

    public Role() {
    }

    public Role(String name, String description, Collection<Permission> permissions) {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    @PrePersist
    @PreUpdate
    private void prePersistOrUpdate() {
        if (this.description == null) {
            this.description = "";
        }

        if (this.users == null) {
            this.users = new ArrayList<>();
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

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getLastModification() {
        return lastModification;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
