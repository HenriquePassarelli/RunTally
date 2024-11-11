package com.runtally.runtally.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "USER")
public class User implements UserDetails {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, updatable = false)
    @NotEmpty(message = "CPF cannot be empty")
    private String cpf;

    @ManyToMany
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @NotEmpty(message = "Roles cannot be empty")
    @JsonIgnoreProperties("users")
    private Collection<Role> roles;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Long createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Long lastUpdate;

    public User() {
    }

    public User(String name, String email, String password, String cpf, Collection<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
