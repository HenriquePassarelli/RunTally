package com.runtally.runtally.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "ATHLETE")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    @NotEmpty(message = "CPF is required")
    @Size(min = 11, max = 11)
    private Long cpf;

    @NotEmpty(message = "Year of birth is required")
    @Column(nullable = false, length = 4)
    @Size(min = 4, max = 4)
    private Integer yearOfBirth;

    @NotEmpty(message = "Gender is required")
    @Pattern(regexp = "^([M|F|O])$", message = "Gender must be M for Male,F for Female,O or Other")
    @Column(nullable = false)
    private String gender;

    private String city;

    private String address;

    private String state;

    private String country;

    private String zipCode;

    private Integer phone;

    @ManyToMany(mappedBy = "athletes")
    @JsonIgnoreProperties({"athletes"})
    private List<Race> races;

    @CreationTimestamp
    private Long createdAt;

    @UpdateTimestamp
    private Long lastModification;

    @PrePersist
    @PreUpdate
    private void prePersistOrUpdate() {
        if (this.races == null) {
            this.races = new ArrayList<>();
        }
    }

    public Athlete() {
    }

    public Athlete(String name, String email, Long cpf, Integer yearOfBirth, String city, String address, String state, String country, String zipCode, Integer phone) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.yearOfBirth = yearOfBirth;
        this.city = city;
        this.address = address;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getCpf() {
        return cpf;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Integer getPhone() {
        return phone;
    }

    public List<Race> getRaces() {
        return races;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getLastModification() {
        return lastModification;
    }
}
