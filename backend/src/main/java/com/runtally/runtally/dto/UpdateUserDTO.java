package com.runtally.runtally.dto;

public record UpdateUserDTO(String id, String name, String password) {
    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
