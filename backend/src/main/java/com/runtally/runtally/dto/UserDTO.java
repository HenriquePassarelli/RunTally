package com.runtally.runtally.dto;

import java.util.List;

public record UserDTO(String name, String username, String email, String cpf, String password, List<Integer> roles) {

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
