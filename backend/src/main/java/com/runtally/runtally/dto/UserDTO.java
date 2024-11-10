package com.runtally.runtally.dto;

public record UserDTO(String name, String email, Integer cpf, String password) {

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                ", password='" + password + '\'' +
                '}';
    }
}
