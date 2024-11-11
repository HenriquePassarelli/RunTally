package com.runtally.runtally.dto;

import java.util.List;

public record UpdateUserDTO(String id, String name, String password, List<Integer> roles) {
    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
